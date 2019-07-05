package com.test.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * 描述:
 *       #选择row模式 需要在mysql上面执行 show variables like "binlog_format" 确保输出是"ROW"格式而不是STATEMENT格式,
 *       否则在rowChage.getRowDatasList()的时候返回的是null,因为默认的STATEMENT只是会把操作的sql记录下来真正的列对应的值没有记录下来
 *
 * @author langyonghe
 * @create 2019-01-17 18:07
 */
public class ClientSample {
    public static void main(String[] args) {
//        CanalConnector connectorCluster = CanalConnectors.newClusterConnector("10.105.10.123:2181,10.105.10.124:2181,10.105.10.125:2181","example", "", "");
        // 创建链接
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress("192.168.10.22", 11111), "example", "canal",
                "canal");// AddressUtils.getHostIp(),
        int batchSize = 1000;
        int emptyCount = 0;
        try {
            connector.connect();
            connector.subscribe(".*\\..*");// .*代表database，..*代表table
            connector.rollback();//
            int totalEmptyCount = 120;
            while (emptyCount < totalEmptyCount) {
                Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    emptyCount++;
                    // System.out.println("empty count : " + emptyCount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                } else {
                    emptyCount = 0;
                    // System.out.printf("message[batchId=%s,size=%s] \n",
                    // batchId, size);
                    printEntry(message.getEntries());
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
            System.out.println("empty too many times, exit");
        } finally {
            connector.disconnect();
        }
    }

    private static void printEntry(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN
                    || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException(
                        "ERROR ## parser of eromanga-event has an error,data:"
                                + entry.toString(), e);
            }
            CanalEntry.EventType eventType = rowChage.getEventType();
            System.out
                    .println(String
                            .format("================> binlog[%s:%s] ,name[%s,%s] , eventType : %s",
                                    entry.getHeader().getLogfileName(), entry
                                            .getHeader().getLogfileOffset(),
                                    entry.getHeader().getSchemaName(), entry
                                            .getHeader().getTableName(),
                                    eventType));
            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    System.out.println("-------> before");
                    printColumn(rowData.getBeforeColumnsList());
                    System.out.println("-------> after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private static void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue()
                    + "    update=" + column.getUpdated());
        }
    }
}
