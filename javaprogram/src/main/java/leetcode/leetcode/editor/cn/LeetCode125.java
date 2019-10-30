// 标题:
//      验证回文串

// 描述:
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

// 思路:

/**
 * Created by huyanshi on 191010
 * <p>
 * 左右两边双指针, 不管哪边,遇到非数字和字母的就跳过, 然后对比左右双指针上的值是否相等, 相等则各移动一位, 否则直接返回false.
 * <p>
 * 当左右交错, 循环结束, 说明必然是回文串.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode125 {
    public static void main(String[] args) {
        Solution solution = new LeetCode125().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) return true;
            s = s.toLowerCase();
            char[] chars = s.toCharArray();
            for (int i = 0, j = s.length() - 1; i <= j; ) {
                if (!isNumOrEng(chars[i])) {
                    i++;
                    continue;
                }
                if (!isNumOrEng(chars[j])) {
                    j--;
                    continue;
                }
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean isNumOrEng(char aChar) {
            if (aChar >= '0' && aChar <= '9') {
                return true;
            }
            if (aChar >= 'a' && aChar <= 'z') {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
