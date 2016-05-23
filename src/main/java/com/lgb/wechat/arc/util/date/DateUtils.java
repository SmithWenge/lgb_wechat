package com.lgb.wechat.arc.util.date;

import org.joda.time.DateTime;

public class DateUtils {
    public static String nowYMD() {
        return DateTime.now().toString("YYYY-MM-dd HH:mm");
    }

    public static String now4Y2M2D() {
        return DateTime.now().toString("YYYY-MM-dd");
    }

    public static String dateFormat4Y2M2D(String date) {
        StringBuilder builder = new StringBuilder()
                .append(date.substring(0, 4)).append("-")
                .append(date.substring(4, 6)).append("-")
                .append(date.substring(6, 8));

        return builder.toString();
    }
}
