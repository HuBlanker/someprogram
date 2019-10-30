// 标题:
//      反转字符串中的单词 III

// 描述:
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串

// 思路:

/**
 * Created by huyanshi on 191025.
 * <p>
 * spilt 之后进行翻转即可. 翻转操作, 左右双指针调换.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode557 {
    public static void main(String[] args) {
        Solution solution = new LeetCode557().new Solution();
        System.out.println(solution.reverseWords("let's go home"));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] s1 = s.split(" ");
            StringBuilder sv = new StringBuilder();
            for (int i = 0; i < s1.length; i++) {
                String a = reverse(s1[i]);
                sv.append(a).append(" ");
            }
            return sv.toString().trim();
        }

        public String reverse(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left <= right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }

            StringBuilder sBuilder = new StringBuilder();
            for (char aChar : chars) {
                sBuilder.append(aChar);
            }
            return sBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
