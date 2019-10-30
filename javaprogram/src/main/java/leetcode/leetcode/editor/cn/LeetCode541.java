// 标题:
//      反转字符串 II

// 描述:
//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。 
//
// 示例: 
//
// 
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 要求: 
//
// 
// 该字符串只包含小写的英文字母。 
// 给定字符串的长度和 k 在[1, 10000]范围内。 
// 
// Related Topics 字符串

// 思路:

/**
 * Created by huyanshi on 191016.
 *
 * 没有使用什么高端技巧, 就是按题目中搞得.
 *
 * 从前向后遍历并计数, 发现当前k个应该翻转的话, 就翻转, 整个操作是在数组上进行的,所以不需要频繁的考虑返回值的问题.
 *
 * 用当前下标 对 2k 取模, 如果小于等k就是应该翻转的区域, 如果大于k就是应该保持不动的区域.
 *
 * 数组翻转特定区域的方法: 左右双指针, 交换, 知道 左右交错.
 *
 * 官方的思路: 本质上是一样的.
 * 不过是直接翻转 nk - n+1 k. n 是偶数. 即 0-k, 2k -3k. 4k -5k. 这样子.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode541 {
    public static void main(String[] args) {
        Solution solution = new LeetCode541().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 3));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            if (s == null || s.length() == 0) return "";
            char[] chars = s.toCharArray();
            int tt = 0;
            for (int i = 0; i < chars.length; i++) {
                if (tt != k - 1) {
                    tt++;
                } else {
                    if ((i ) % (2 * k) <= k) {
                        reverseLast(chars, i - k + 1, i);
                    }
                    tt = 0;
                }
            }
            if (tt != 0) {
                if ((chars.length ) % (2 * k) <= k)
                reverseLast(chars, chars.length - (chars.length % k), chars.length - 1);
            }

            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            return sb.toString();
        }
        // 翻转 l-r 之间的数组
        public void reverseLast(char[] chars, int l, int r) {
            for (; l < r; l++, r--) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
            }
        }


        /**
         *  感觉我那个想法还是复杂了, 理论上讲, 不需要一个一个遍历, 只需要 0 ,2k, 4k, 跳着做就好了.
         *  然后在每一次循环中, 判断后面要翻转多长的距离, (因为存在剩余不满k个的情况.) 进行翻转.
         *  然后判断后面有多长的数据保持不动, 也可能存在不满k的情况.
         *  就结束了. 这个方法比较简单.
         *
         *  这个的中心思想就是: 不用一个一个遍历, 直接2k,2k的跳着走.
         */
        public String reverseStr2(String s, int k) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i = i + 2 * k) {
                if (s.length() >= (i + k)) {
                    sb.append(new StringBuilder(s.substring(i, i + k)).reverse());
                } else {
                    sb.append(new StringBuilder(s.substring(i)).reverse());
                    break;
                }

                if ((i + 2 * k) <= s.length()) {
                    sb.append(s.substring(i + k, i + 2 * k));
                } else {
                    sb.append(s.substring(i + k));
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
