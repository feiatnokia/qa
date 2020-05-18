package com.tututu.qa.utils;

import java.util.Objects;

/**
 * @author Yu QiLin
 * @Description YES or NO
 * @createTime 2020年05月18日 11:15:00
 */
public enum  YesOrNoEnum {
    YES("Y"), NO("N");

    private String value;

    YesOrNoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static YesOrNoEnum create(String value) {
        for (YesOrNoEnum item : YesOrNoEnum.values()) {
            if (item.getValue().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return YesOrNoEnum.NO;
    }

    public boolean sameAs(YesOrNoEnum other) {
        if (other == null) {
            return false;
        }
        return Objects.equals(getValue(), other.getValue());
    }

    public static boolean yes(String value) {
        return YES.getValue().equalsIgnoreCase(value);
    }

    public static boolean no(String value) {
        return NO.getValue().equalsIgnoreCase(value);
    }
}