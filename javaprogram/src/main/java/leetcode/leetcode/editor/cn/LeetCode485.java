// 标题:
//      最大连续1的个数

// 描述:
//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组

// 思路:

/**
 * Created by huyanshi on 191029.
 *
 *  从前向后遍历, 设置两个计数器, 一个统计当前连续1的个数, 一个统计最大连续1的个数.
 *  每当遇到0的时候,重置第一个计数器, 把当前值和第二个计数器做max.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode485 {
    public static void main(String[] args) {
        Solution solution = new LeetCode485().new Solution();
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int max = 0;
            int now = 0;
            for (int num : nums) {
                if (num == 1) {
                    now++;
                } else {
                    max = Math.max(max, now);
                    now = 0;
                }
            }
            max = Math.max(max, now);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
