//用此类进行转换

package cn.net.lovelive.mintoolbox.tool.ASCII;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeASCII {
    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }
    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
    public static boolean test_ascii(String str){        //判断输入的字符串是否符合ASCII TO STRING的要求
        Pattern p = Pattern.compile("^(\\d+,\\d+)+$");
        Matcher m = p.matcher(str);
        boolean rs = m.matches();
        return  rs;
    }

}
