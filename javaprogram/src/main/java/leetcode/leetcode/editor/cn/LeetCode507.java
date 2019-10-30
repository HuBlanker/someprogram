// 标题:
//      完美数

// 描述:
//对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。 
//
// 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False 
//
// 
//
// 示例： 
//
// 输入: 28
//输出: True
//解释: 28 = 1 + 2 + 4 + 7 + 14
// 
//
// 
//
// 提示： 
//
// 输入的数字 n 不会超过 100,000,000. (1e8) 
// Related Topics 数学

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * 1. 从 1- n-1进行遍历, 如果能够整除则是一个因子. 这样会超时.
 *      我们可以优化一下,, 在整除的时候, 同时加上两个因子, 比如 28/2 = 14, 我们同时给结果加上 2,14
 *      这样就要处理两个特殊情况, 因子为1 和 为平方根的情况. 为1的时候, n本身不要, 为平方根的时候, 只要一个平方根即可.
 *      这样优化之后可以提交成功.
 *
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode507 {
    public static void main(String[] args) {
        Solution solution = new LeetCode507().new Solution();
        System.out.println(solution.checkPerfectNumber(28));
        System.out.println(solution.checkPerfectNumber(29));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num == 0) return false;
            int ret = 0;
            int left = 1;
            int right = num - 1;
            while (left < right) {
                if ((num % left) == 0) {
                    ret += left;
                    int i = num / left;
                    if (i != left && i != num) {
                        ret += i;
                    }
                    right = i;
                }
                left++;
            }
            return ret == num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
