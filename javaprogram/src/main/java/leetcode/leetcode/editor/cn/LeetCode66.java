// 标题:
//      加一

// 描述:
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

// 思路:

/**
 * 考虑一下进位, 以及 999 + 1 = 1000, 这种多一位的情况即可.
 */

// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode66{
       public static void main(String[] args) {
            Solution solution = new LeetCode66().new Solution();
           int a[] = {9, 9, 9};
           int b[] = {4, 3, 2, 2};
           int c[] = {0};
           System.out.println(Arrays.toString(solution.plusOne(a)));
           System.out.println(Arrays.toString(solution.plusOne(b)));
           System.out.println(Arrays.toString(solution.plusOne(c)));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (plus == 0) {
                break;
            }
            int i1 = digit + plus;
            digits[i] = i1 % 10;
            plus = i1 / 10;
        }

        if (plus != 0) {
            int a[] = new int[digits.length + 1];
            a[0] = 1;
            System.arraycopy(digits, 0, a, 1, digits.length);
            return a;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
