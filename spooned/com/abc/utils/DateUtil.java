package com.abc.utils;


public class DateUtil {
    private static final java.lang.String FORMAT = "yyyyMMddHHmmss";

    private java.lang.String utilName;

    public DateUtil() {
        super();
    }

    public DateUtil(java.lang.String utilName) {
        super();
        this.utilName = utilName;
    }

    public static java.lang.String getIdByTime() {
        java.util.Date now = new java.util.Date();
        java.text.SimpleDateFormat simple = new java.text.SimpleDateFormat(com.abc.utils.DateUtil.FORMAT);
        return simple.format(now);
    }
}

