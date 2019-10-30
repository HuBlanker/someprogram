// 标题:
//      两数之和 II - 输入有序数组

// 描述:
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找

// 思路:

/**
 * Created by huyanshi on 191022.
 *
 * 1. 双指针法. 对于每一次的i, j = i+1 进行一次遍历, 时间复杂度 O(N2).
 *
 * 2. 因为是排序数组, 因此我们可以使用左右双指针来做, 左右双指针, 如果相加大于目标值, 那右指针左移, 如果小于左指针右移.
 * 可以在 O(N) 的时间复杂度下找到答案.
 *
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode167{
       public static void main(String[] args) {
            Solution solution = new LeetCode167().new Solution();
           int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
           System.out.println(Arrays.toString(ints));


           int[] a = solution.twoSum(new int[]{-1, 0}, -1);
           System.out.println(Arrays.toString(a));
       }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[0];
        for (int i = 0; i < numbers.length -1; i++) {
            if (numbers[i] > target) {
                break;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
        
    }
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[0];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int i = numbers[left] + numbers[right];
            if (i == target) {
                return new int[]{left + 1, right + 1};
            } else if (i > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
