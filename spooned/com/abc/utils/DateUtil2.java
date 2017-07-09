package com.abc.utils;


public final class DateUtil2 {
    private static final java.lang.String FORMAT = "yyyyMMddHHmmss";

    private java.lang.String utilName;

    protected DateUtil2() {
        super();
    }

    private DateUtil2(java.lang.String utilName) {
        super();
        this.utilName = utilName;
    }

    public static java.lang.String getIdByTime() {
        java.util.Date now = new java.util.Date();
        java.text.SimpleDateFormat simple = new java.text.SimpleDateFormat(com.abc.utils.DateUtil2.FORMAT);
        return simple.format(now);
    }
}

