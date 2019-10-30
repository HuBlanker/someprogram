// 标题:
//      x 的平方根

// 描述:
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

// 思路:

/**
 * 二分法.注意返回较小的一个,也就是right. 还有会有溢出问题. 中间相乘的结果要注意处理溢出.
 */
// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode69 {
    public static void main(String[] args) {
        Solution solution = new LeetCode69().new Solution();
        System.out.println(solution.mySqrt(10));
        System.out.println(solution.mySqrt(20));
        System.out.println(solution.mySqrt(2147395599));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int y = x;
            if (x > 4) y = y / 2;

            int left = 0;
            int right = y;
            while (left <= right) {
                int mid = (left + right) / 2;
                long mul = (long)mid * mid;
                if (mul < 0 || mul > Integer.MAX_VALUE) {
                    right = mid - 1;
                    continue;
                }
                if (mul == x) return mid;

                if (mul < x ) {
                    left = mid + 1;
                }
                if (mul > x ) right = mid - 1;
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
