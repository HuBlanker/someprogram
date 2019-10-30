// 标题:
//      数组拆分 I

// 描述:
//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。 
//
// 示例 1: 
//
// 
//输入: [1,4,3,2]
//
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
// 
//
// 提示: 
//
// 
// n 是正整数,范围在 [1, 10000]. 
// 数组中的元素范围在 [-10000, 10000]. 
// 
// Related Topics 数组

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * 直接排序, 然后返回偶数下标的值的和即可
 * .
 *
 * 因为想要获得最大的总和, 本质上就是让大的和大的分组.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode561 {
    public static void main(String[] args) {
        Solution solution = new LeetCode561().new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int ret = 0;
            for (int i = 0; i < nums.length; i += 2) {
                ret += nums[i];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
