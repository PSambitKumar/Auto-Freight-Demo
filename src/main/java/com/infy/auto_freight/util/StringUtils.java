package com.infy.auto_freight.util;

public class StringUtils {

    public static boolean isStringNotEmpty(String data) {
        return data != null && !data.isBlank();
    }

    public static boolean isEmpty(String data) {
        return data == null || data.isEmpty();
    }
}
