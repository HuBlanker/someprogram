// 标题:
//      只出现一次的数字

// 描述:
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表

// 思路:

/**
 * Created by huyanshi on 191011
 * <p>
 * 首先这题 肯定可以通过hash表, 每个数字进行计数来解决的. 如果 数字的范围密集, 也可以数组来计数.
 * <p>
 * 当然这个题 更好的办法是利用位运算. 异或 ^ 运算: x ^ 0 = x. x ^ x = 0;
 * <p>
 * 因此数组中的所有数字进行异或, 得到的结果就是只出现了一次的数字.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode136 {
    public static void main(String[] args) {
        Solution solution = new LeetCode136().new Solution();
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
