// 标题:
//      打家劫舍

// 描述:
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划

// 思路:

/**
 * Created by huyanshi on 191018.
 * 重点是分析规则咯
 *
 * n = 1 : f(1) = nums[1]
 * n = 2 : f(2) = Math(nums[1], nums[2])
 * n = 3 : 有两个选择, 1,3 和只取 2. 所以 f(3) = Math(f(1) + nums[3], f(2))
 *
 * 所以可以得出: f(k) = math(f(k-2) + now , f(k-1))
 *
 * 得到状态转移方程就简单了.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode198{
       public static void main(String[] args) {
            Solution solution = new LeetCode198().new Solution();
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int num : nums) {
            int tmp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = tmp;
        }
        return curMax;

    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
