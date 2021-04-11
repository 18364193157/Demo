package com.test.inspur;

/**
 * @author langyonghe
 * @date 2021/1/22 11:08
 */
public enum  KeyInterfaceImpl implements KeyInterface {
    CONCURRENT_PROCESSOR_ID("concurrent.processor.id"),
    PRE_PROCESSOR_ID("previous.processor.id"),
    SOURCE_DB("database.source"),
    SOURCE_TABLE_NAME("database.source.table.name"),
    SOURCE_TABLE_PRIME_KEY("table.primary.key"),
    DEST_DB("database.destination"),
    DEST_TABLE_NAME("database.destination.table.name");

    private String key;

    KeyInterfaceImpl(String key) {
        this.key = key;
    }

    @Override
    public String key() {
        return this.key;
    }

}
