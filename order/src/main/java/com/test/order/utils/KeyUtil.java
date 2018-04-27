package com.test.order.utils;

import java.util.Random;

/**
 *
 * @author chudichen
 * @date 2018/4/15
 */
public class KeyUtil {

    /**
     * Generate unique primary key.
     *
     * @return key
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
