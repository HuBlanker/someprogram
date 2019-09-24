// 标题:
// 整数反转

// 描述:
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

// 思路:

/**
 * 这道题就是基本的取模和整出运算, 注意在处理溢出,且有大于小于两种溢出.
 * 溢出处理:
 * 1. 直接trycatch是最简单的,但是也是不太好的.
 * 2. 用字符串stringbuilder来解题,中间自己判断溢出.
 * 3. 用long来表示结果, 判断溢出, 最后转成int即可.
 * <p>
 * 代码里使用了第三种.
 */
// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode7 {
    public static void main(String[] args) {
        Solution solution = new LeetCode7().new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(-2147483648));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long ret = 0;
            while (x != 0) {
                ret = ret * 10 + (x % 10);
                x /= 10;
            }
            if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
