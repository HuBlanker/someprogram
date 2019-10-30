// 标题:
// 移除元素

// 描述:
//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 1: 
//
// 给定 nums = [3,2,2,3], val = 3,
//
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2: 
//
// 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
//
//函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//
//注意这五个元素可为任意顺序。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针

// 思路:

/**
  和leetcode.leetcode.editor.cn.LeetCode26中的思想一样.
  只是判断移动一个元素的条件,从已有数组中重复项, 变成了和输入值相等.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode27 {
    public static void main(String[] args) {
        Solution solution = new LeetCode27().new Solution();
        int[] a = {1, 2, 3, 4, 4, 2, 1};
        System.out.println(solution.removeElement(a, 2));
        int[] b = {3, 2, 2, 3};
        System.out.println(solution.removeElement(b, 3));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int tail = 0;
            for (int i = 0; i < nums.length - tail; ) {
                if (nums[i] == val) {
                    int tmp = nums[i];
                    if (nums.length - 1 - i >= 0) System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                    nums[nums.length - 1] = tmp;
                    tail++;
                } else {
                    ++i;
                }
            }
            return nums.length - tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
