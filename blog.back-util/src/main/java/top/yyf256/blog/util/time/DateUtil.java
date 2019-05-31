package top.yyf256.blog.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String DATE_FORMAT="yyyyMMdd";

    /**
     * 获取当前系统日期
     * @return yyyyMMdd
     */
    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }
}
