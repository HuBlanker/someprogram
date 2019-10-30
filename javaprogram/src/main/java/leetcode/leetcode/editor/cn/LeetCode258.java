// 标题:
//      各位相加

// 描述:
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学

// 思路:

/**
 * Created by huyanshi on 191023.
 * <p>
 * 1. 循环计算, 小于10的时候返回. 由于结果必然存在, 所以不用考虑有向无环图.
 * <p>
 * 2. 找规律,
 * x < 9: x
 * x > 9 & x % 9 = 0 : 9
 * x > 9 & x % 9 !=0 : x % 9
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.HashSet;
import java.util.Set;

public class LeetCode258 {
    public static void main(String[] args) {
        Solution solution = new LeetCode258().new Solution();
        System.out.println(solution.addDigits(38));
        System.out.println(solution.addDigits(10));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addDigits(int num) {
            int ret = num;
            while (ret >= 10) {
                ret = sumS(ret);
            }
            return ret;

        }

        private int sumS(int num) {
            int result = 0;
            while (num != 0) {
                result += (num % 10);
                num /= 10;
            }
            return result;
        }


        public int addDigits2(int num) {
            return (num - 1) & 9 + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
