// 标题:
// 删除排序数组中的重复项

// 描述:
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
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
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
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
 * 题目提示是双指针, 但是我感觉要三个.
 * 1. 从头开始遍历,对于每一个值, 遍历之前的所有值判断有没有出现过.
 * 2. 如果没有出现过, 继续. 出现过, 则将此值移至数组尾部,且之后的元素统一前移一位. 尾部的指针向前移动一位.
 * 3. 尾部有一个指示指针,从后向前, 当和前面的1号指针相遇,说明数组遍历完成,结束.
 */
// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode26 {
    public static void main(String[] args) {
        Solution solution = new LeetCode26().new Solution();
        int[] a = {1, 2, 3, 4, 5, 5, 5, 5, 6};
        System.out.println(solution.removeDuplicates(a));
        int[] b = {1, 1, 2, 2, 5, 5, 2, 5, 6};
        System.out.println(solution.removeDuplicates(b));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int tail = 0;
            for (int i = 0; i < nums.length - tail; ) {

                boolean haveSame = false;
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) haveSame = true;
                }
                if (haveSame) {
                    int tmp = nums[i];
                    if (nums.length - 1 - i >= 0) System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                    nums[nums.length - 1] = tmp;
                    tail++;
                } else {
                    i++;
                }
            }
            return nums.length - tail;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
