// 标题:
//      搜索插入位置

// 描述:
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

// 思路:

/**
 * 二分就完事了.
 * 当找不到的时候, 此时的target 必然在 left 和right 之间. 返回他们的较大者,也就是left即可.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode35 {
    public static void main(String[] args) {
        Solution solution = new LeetCode35().new Solution();
        int[] a = {1, 3, 5, 7, 9};
        System.out.println(solution.searchInsert(a, 4));
        System.out.println(solution.searchInsert(a, 6));
        System.out.println(solution.searchInsert(a, 8));
        System.out.println(solution.searchInsert(a, 4));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (target < nums[0]) return 0;
            if (target > nums[nums.length - 1]) return nums.length;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int num = nums[mid];
                if (num == target) return mid;
                if (num > target) right = mid - 1;
                if (num < target) left = mid + 1;
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
