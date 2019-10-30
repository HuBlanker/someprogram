// 标题:
//      合并两个有序数组

// 描述:
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

// 思路:

/**
 * 从后向前遍历, 这样子不用移动数据,比较方便.
 * 每次获取两个数组中较大的一个, 放到前一个位置.
 * 如果1数组先完,把数组2剩余下的copy过来.
 * 如果数组2先完, 那么数组1已经是有序的,不用管.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode88 {
    public static void main(String[] args) {
        Solution solution = new LeetCode88().new Solution();
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 5, 6};
        solution.merge(nums1, 1, nums2, 5);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {2, 0};
        int[] nums4 = {1};
        solution.merge(nums3, 1, nums4, 1);
        System.out.println(Arrays.toString(nums3));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len = m + n - 1;
            int i = m - 1;
            int j = n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[len] = nums1[i];
                    len--;
                    i--;
                } else {
                    nums1[len] = nums2[j];
                    len--;
                    j--;
                }
            }
            while (i <= 0 && j >= 0) {
                nums1[len] = nums2[j];
                len--;
                j--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
