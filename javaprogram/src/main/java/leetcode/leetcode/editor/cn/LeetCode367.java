// 标题:
//      有效的完全平方数

// 描述:
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找

// 思路:

/**
 * Created by huyanshi on 191023.
 *
 * 1. 直接求它的平方根, 能求出来就是完全平方数, 否则就不是.
 *
 * 2. 牛顿迭代法.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import sun.java2d.pipe.SpanIterator;

public class LeetCode367 {
    public static void main(String[] args) {

        Solution solution = new LeetCode367().new Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(17));
        System.out.println(solution.isPerfectSquare(0));
        System.out.println(solution.isPerfectSquare(1));
        System.out.println(solution.isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 0) return false;
            int tmp = num;
            if (num > 4) tmp = tmp / 2;
            int left = 0;
            int right = tmp;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);

                long i = (long)mid * mid;
                if (i > Integer.MAX_VALUE) {
                    right = (int) mid - 1;
                    continue;
                }
                if (i == num) return true;
                if (i > num) {
                    right = mid - 1;
                }
                if (i < num) {
                    left = mid + 1;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
