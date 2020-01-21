package com.zuniorteam.racingcar.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String value){
        return value == null || value.trim().equals("");
    }
}
