package top.yyf256.blog.util;

import top.yyf256.util.string.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsValidUtil {

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 是否为大于0的整数
     * @param str
     * @return
     */
    public static boolean isOverZeroInt(String str) {
        try {
            Integer number = Integer.parseInt(str);
            if (number > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    /**
     * 去除字符串最后一位
     *
     * @param str
     * @return
     */
    public static String removeLastChart(String str) {
        return str.substring(0, str.length() - 1);
    }

    /**
     * 不为空并且小于最大值
     *
     * @param source
     * @param max
     * @return
     */
    public static boolean notNullAndLessThanMaxLength(String source, int max) {
        if (!StringUtil.stringIsBlank(source) && source.length() <= max) {
            return true;
        }
        return false;
    }

    /**
     * 为空或者小于最大值
     *
     * @param source
     * @param max
     * @return
     */
    public static boolean nullOrLessThanMaxLength(String source, int max) {
        if (StringUtil.stringIsBlank(source)) {
            return true;
        }
        if (source.length() <= max) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(removeLastChart("122a3223"));
    }
}
