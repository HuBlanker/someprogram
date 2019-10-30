// 标题:
//      旋转数组

// 描述:
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组

// 思路:

/**
 * Created by huyanshi on 191018.
 * <p>
 * 解法1: 每次旋转最后一个元素,  循环k次.
 * 时间复杂度, O(kn) 空间 O(1)
 * 解法2: 翻转三次. 第一次全部数组,第二次前0-k部分, 第三次 k-n部分. 可以达到和要有的效果.
 * 时间O(n), 翻转了三次数组. 空间O(1)
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode189 {
    public static void main(String[] args) {
        Solution solution = new LeetCode189().new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));


        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate2(nums1, 3);
        System.out.println(Arrays.toString(nums1));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 时间复杂度, O(kn) 空间 O(1)
        public void rotate(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                retateLast(nums);
            }
        }

        public void retateLast(int[] nums) {
            if (nums == null || nums.length == 0) return;
            int length = nums.length;
            int tmp = nums[length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }


        // 时间O(n), 翻转了三次数组. 空间O(1)
        public void rotate2(int[] nums, int k) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int l, int r) {
            int i = l, j = r;
            while (i < j) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
                j--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
