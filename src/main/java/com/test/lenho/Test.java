package com.test.lenho;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import java.util.*;

/**
 * 描述:
 *
 * @author langyonghe
 * @create 2019-06-07 10:14
 */
public class Test {
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";
    public static void main(String[] args) {
//        DateTime dateTime = new DateTime(new Date());
//        System.out.println(dateTime);

        String s = new DateTime(new Date()).toString(CRON_DATE_FORMAT);
        System.out.println(s);


//        List<Long> list = new ArrayList<>();
//        System.out.println(StringUtils.join(list,","));
    }
}
