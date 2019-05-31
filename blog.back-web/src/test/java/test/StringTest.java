package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) {

        String html ="<p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p><p><img src=\"http://image.public.yyf256.top/technical/20190516/1558015825623\" style=\"max-width:100%;\">DSFSDFSFSD</p><p><img src=\"http://image.public.yyf256.top/technical/20190516/1558015834954\" style=\"max-width:100%;\">SDFDSFSD</p><p>FSDFDSFS哈哈哈哈<br></p>";
        Pattern pattern = Pattern.compile("http://image.public.yyf256.top/.*?\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()){
            String str = matcher.group();
            str = str.substring(0,str.length()-1);
            System.out.println(str);
        }

        String str = "今天遇到一个问题,有两个html界面A、B，我从A跳转到B，并给B传来一个参数param,该参数可能为中文，当我跳转到B界面时，通过以下函数：获取参数param的值时，出现了param乱码的问题";
        System.out.println("字符串长度:"+str.length());
    }
}
