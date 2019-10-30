// 标题:
//      最大子序和

// 描述:
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

// 思路:

/**
 * 核心思想就是: 一次遍历, 一直向前加, 如果当前的和为负数, 且下一个数字大于当前的和, 不如就从下一个重新开始.
 * 注意区分一下, 和 - 最大和的区别,需要分开存储. 因为不能保证最大和在最后得到.
 *
 * 以题目中的例子来看:
 *
 * [-2,1,-3,4,-1,2,1,-5,4]
 *
 * 1. sum = -2, max = -2;
 * 2. sum = -1 , 不如直接从1开始好了. 所以 sum = 1, max = 1;
 * 3. sum = -4, max = 1
 * 4. sum = 0, 不如直接从4开始好了, sum = 4, max = 4
 * 5. sum = 3, max = 4
 * 6. sum = 5, max = 5;
 * 7. sum = 6, max =6;
 * 8, sum = 1, max = 6;
 * 9. sum = 5, max = 6;
 * 返回6.
 */

// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode53{
       public static void main(String[] args) {
            Solution solution = new LeetCode53().new Solution();
           int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
           System.out.println(solution.maxSubArray(a));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0 && nums[i] > sum) sum = 0;
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
