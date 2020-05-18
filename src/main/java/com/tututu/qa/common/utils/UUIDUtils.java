package com.tututu.qa.common.utils;

import java.util.UUID;

/**
 * @program: qa
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 19:12
 **/
public class UUIDUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static Long uuidLong() {
        StringBuffer sb = new StringBuffer();
        sb.append(getFourRandom()).append(getFiveRandom()).append(getTwoRandom())
                .append(getThreeRandom()).append(getTwoRandom());
        return Long.parseLong(sb.toString());
    }

    public static String getEightRandom() {
        int fourNum = (int) (Math.random() * (99999999 - 10000000 + 1)) + 10000000;

        return fourNum + "";
    }

    public static String getFourRandom() {
        int fourNum = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;

        return fourNum + "";
    }

    public static String getFiveRandom() {
        int fourNum = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;

        return fourNum + "";
    }

    public static String getTwoRandom() {
        int fourNum = (int) (Math.random() * (99 - 10 + 1)) + 10;

        return fourNum + "";
    }

    public static String getThreeRandom() {
        int fourNum = (int) (Math.random() * (999 - 100 + 1)) + 100;

        return fourNum + "";
    }
}
