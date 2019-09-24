// 标题:
// 回文数

// 描述:
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学

// 思路:

/**
 * 直接翻转整数. 小于0 直接返回false.
 * 翻转后和原来相等, 就是回文数.否则不是.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode9 {
    public static void main(String[] args) {
        Solution solution = new LeetCode9().new Solution();
        System.out.println(solution.isPalindrome(121));;
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x == rev(x)) {
                return true;
            }

            return false;
        }

        public int rev(int x) {
            long ret = 0;
            while (x != 0) {
                ret = ret * 10 + x % 10;
                x /= 10;
            }
            if (ret > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
