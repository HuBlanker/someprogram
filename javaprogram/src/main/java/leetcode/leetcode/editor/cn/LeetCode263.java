// 标题:
//      丑数

// 描述:
//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学

// 思路:

/**
 * Created by huyanshi on 191023.
 *
 * 1. 不断整除 2,3,5, 直到为1, 则为真, 如果一个数不等1且不能被2,3,5之一整除, 那就不是丑数.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode263 {
    public static void main(String[] args) {
        Solution solution = new LeetCode263().new Solution();
        System.out.println(solution.isUgly(9));
        System.out.println(solution.isUgly(8));
        System.out.println(solution.isUgly(14));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int num) {
            if (num <= 0) return false;
            while (num != 1) {
                if (num % 2 == 0) num /= 2;
                else if (num % 3 == 0) num /= 3;
                else if (num % 5 == 0) num /= 5;
                else return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
