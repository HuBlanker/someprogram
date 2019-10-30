package com.huyan;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.*;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;

/**
 * Created by pfliu on 2019/09/11.
 */
public class StringUtils {


    /**
     * 当前字符是否是中文字符
     */
    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    /**
     * 当前字符串是否包含中文字符
     */
    public static boolean containChinese(String str) {
        if (str == null) return false;
        for (char c : str.toCharArray()) {
            if (isChinese(c)) return true;
        }
        return false;
    }

    /**
     * 获取字符串的拼音
     */
    public static String getPinyin(String key) throws BadHanyuPinyinOutputFormatCombination {
        if (key == null) return null;
        char[] chars = key.toCharArray();
        StringBuilder sb = new StringBuilder();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char aChar : chars) {
            String[] strings = PinyinHelper.toHanyuPinyinStringArray(aChar, defaultFormat);
            if (strings == null || strings.length == 0) {
                sb.append(aChar);
            } else {
                // 不考虑多音字
                sb.append(strings[0]);
            }
        }
        return sb.toString();
    }

    /**
     * 是否是变位词, abc = bac
     */
    public static boolean isChangeLocation(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);

        if (chars.length == chars1.length) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != chars1[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * s1 是否是s2 的子序列
     */
    public static boolean isSubQ(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        if (s1.length() == s2.length()) return s1.equals(s2);
        int i = 0, j = 0;
        for (; i < s1.length() && j < s2.length(); ) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                i++;
            } else {
                j++;
            }
        }
        return i >= s1.length();
    }

    /**
     * 求公共前缀的长度
     */
    public static int prefixLength(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }


}
