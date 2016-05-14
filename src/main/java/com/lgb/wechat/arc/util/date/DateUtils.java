package com.lgb.wechat.arc.util.date;

import org.joda.time.DateTime;

public class DateUtils {
    public static String nowYMD() {
        return DateTime.now().toString("YYYY-mm-dd HH:mm");
    }
}
