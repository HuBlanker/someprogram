package com.huyan;

/**
 * Created by pfliu on 2019/09/11.
 */
public class StringUtils {


    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    public static boolean containChinese(String str) {
        if (str == null) return false;
        for (char c : str.toCharArray()) {
            if (isChinese(c)) return true;
        }
        return false;
    }

}
