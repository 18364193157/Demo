package com.test.currentandsafe.mode;

import lombok.Data;
import lombok.ToString;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-03-12 10:30
 */
@ToString
@Data
public final class PCData {

    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }

}
