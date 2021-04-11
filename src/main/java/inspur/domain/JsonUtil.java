package inspur.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author langyonghe
 * @date 2021/2/25 9:50
 */
@Slf4j
public class JsonUtil {
    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static SerializeConfig config;

    static {
        config = new SerializeConfig();
        config.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    private static final SerializerFeature[] features = {
            // 输出空置字段
            SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty
    };

    /** Object TO Json String 字符串输出 */
    public static String toJSON(Object object) {
        try {
            return JSON.toJSONString(object, config, features);
        } catch (Exception e) {
            logger.error("JsonUtil | method=toJSON() | 对象转为Json字符串 Error！" + e.getMessage(), e);
        }
        return null;
    }

    /** Object TO Json String Json-lib兼容的日期输出格式 */
    public static String toJSONLib(Object object) {
        try {
            return JSON.toJSONString(object, config, features);
        } catch (Exception e) {
            logger.error("JsonUtil | method=toJSONLib() | 对象转为Json字符串 Json-lib兼容的日期输出格式   Error！" + e.getMessage(), e);
        }
        return null;
    }

    /** 转换为数组 Object */
    public static Object[] toArray(String text) {
        try {
            return toArray(text, null);
        } catch (Exception e) {
            logger.error("JsonUtil | method=toArray() | 将json格式的数据转换为数组 Object  Error！" + e.getMessage(), e);
        }
        return null;
    }

    /** 转换为数组 （可指定类型） */
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        try {
            return JSON.parseArray(text, clazz).toArray();
        } catch (Exception e) {
            logger.error("JsonUtil | method=toArray() | 将json格式的数据转换为数组 （可指定类型）   Error！" + e.getMessage(), e);
        }
        return null;
    }

    /** Json 转为 Jave Bean */
    public static <T> T toBean(String text, Class<T> clazz) {
        try {
            return JSON.parseObject(text, clazz);
        } catch (Exception e) {
            logger.error("JsonUtil | method=toBean() | Json 转为  Jave Bean  Error！" + e.getMessage(), e);
        }
        return null;
    }

    /** Json 转为 Map */
    public static Map<?, ?> toMap(String json) {
        try {
            return JSON.parseObject(json);
        } catch (Exception e) {
            logger.error("JsonUtil | method=toMap() | Json 转为   Map {},{}" + e.getMessage(), e);
        }
        return null;
    }

    /** Json 转 List,Class 集合中泛型的类型，非集合本身，可json-lib兼容的日期格式 */
    public static <T> List<T> toList(String text, Class<T> clazz) {
        try {
            return JSON.parseArray(text, clazz);
        } catch (Exception e) {
            logger.error("JsonUtil | method=toList() | Json 转为   List {},{}" + e.getMessage(), e);
        }
        return null;
    }

    /** 从json字符串获取指定key的字符串 */
    public static Object getValueFromJson(final String json, final String key) {
        try {
            if (StringUtils.isBlank(json) || StringUtils.isBlank(key)) {
                return null;
            }

            return JSON.parseObject(json).getString(key);
        } catch (Exception e) {
            logger.error("JsonUtil | method=getStringFromJson() | 从json获取指定key的字符串 Error！" + e.getMessage(), e);
        }
        return null;
    }

    /** 从json字符串获取指定key的字符串 */
    public static JSONObject getJSONObjectFromJson(final String json) {
        try {
            if (StringUtils.isBlank(json)) {
                return null;
            }
            return JSON.parseObject(json);
        } catch (Exception e) {
            logger.error("JsonUtil | method=getStringFromJson() | 从json获取指定key的字符串 Error！" + e.getMessage(), e);
        }
        return null;
    }


    public static void main(String[] args) {
        String str = "{\"jobId\":\"fad0c0eec660422d8f03a2bd74fa806a\",\"jobType\":\"REGEX_JOB\",\"name\":\"lenho001\",\"folderId\":\"d6a99dba-0177-1000-0000-000073e4175b\",\"dataTraceOpen\":\"false\",\"sourceInfo\":{\"dataSourceId\":\"d6bc4aa4-0177-1000-0000-00005af1c6a5\",\"owner\":\"\",\"tableName\":\"space_info\",\"jobMode\":\"stock\",\"directory\":\"\",\"dataSourceType\":\"Mysql\",\"dataSourceName\":\"lenho124\",\"tableType\":\"TABLE\",\"newSqlKafkaServiceName\":\"\"},\"targetInfo\":{\"dataSourceType\":\"SFTP\",\"dataSourceId\":\"d6d06ef0-0177-1000-ffff-ffffcf36a65a\",\"owner\":\"null\",\"namespace\":\"\",\"dataSourceName\":\"lenho113sftp\",\"frontSQL\":\"\",\"endSQL\":\"\",\"operateType\":\"\",\"rowKey\":\"\",\"ESindex\":\"\",\"ESindexType\":\"\",\"directory\":\"\",\"ESKey\":\"\",\"kafkaTopic\":\"\",\"kafkaServiceName\":\"\",\"writePath\":\"/root/lenho\",\"conflictResolution\":\"REPLACE\"},\"dataProcessors\":[{\"type\":\"org.apache.nifi.processors.inspur.clean.ValidateResult\",\"name\":\"结果校验\",\"params\":{\"Clean Column\":\"id\",\"ValidRule\":\"^[A-Za-z]+$_26个英文字母组成\",\"Source Table\":\"\"}},{\"type\":\"org.apache.nifi.processors.avro.ConvertAvroToJSON\",\"name\":\"转为json格式\",\"params\":{\"JSON container options\":\"array\",\"Wrap Single Record\":\"false\",\"Avro schema\":\"\"}}],\"scheduleInfo\":{\"schedulingMode\":\"MANUAL\",\"scheduleValue\":\"31536000 sec\",\"concurrentTasks\":\"1\",\"rate\":\"0\"}}";
//        String string = JSON.parseObject(str).getJSONObject("sourceInfo").getString("dataSourceId");
//        System.out.println(string);
//        Student student = new Student("123");
//        Student.getTest();
        String dataSourceType = (String)getValueFromJson(str, "sourceInfo.dataSourceType");
        System.out.println(dataSourceType);
    }
}