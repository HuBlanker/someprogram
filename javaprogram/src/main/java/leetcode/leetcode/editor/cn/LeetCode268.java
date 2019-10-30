// 标题:
//      缺失数字

// 描述:
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学

// 思路:

/**
 * Created by huyanshi on  191017.
 *
 * 解法1: 排序, 然后看 位置上的值不是下标+1的就是缺失值 +1. 时间空间复杂度没法同时满足题目中的要求.
 *
 * 解法2: hash表, 直接对每一个计数, 然后按个遍历看看有没有, 时间O(n), 空间O(N).
 *
 * 解法3: 异或. 给数组中把所有数据都添加1个. 题目就变成了, 数组中所有数字都出现了两次, 找到那个只出现了一次的数字. 是不是很熟悉.
 *
 * 异或: x ^ x = 0. x ^ 0 = x.  且符合交换律, 所以对1-n的所有数字异或, 再和数组中所有数字异或,拿到的结果就是缺失的数字.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode268{
       public static void main(String[] args) {
            Solution solution = new LeetCode268().new Solution();
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int ret = 0;
        for (int i = 0; i <= nums.length; i++) {
            ret ^= i;
        }

        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
