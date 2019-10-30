// 标题:
//      二进制求和

// 描述:
//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串

// 思路:

/**
 * 有两种思路吧,
 * 第一种:
 *      写个十进制和二进制的转换, 然后转成10进制相加.再转回来. 太无聊了.
 *
 * 第二种:
 *      按照十进制那种想法加, 每次相加的结果对2取模和除以2.
 *
 *      主要注意整体进位的情况, 类似于10进制的 999 + 1 = 1000. 这种情况.
 *

 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Stack;

public class LeetCode67 {
    public static void main(String[] args) {
        Solution solution = new LeetCode67().new Solution();
        System.out.println(solution.addBinary("11","1"));
        System.out.println(solution.addBinary("1010","1011"));
        System.out.println('1' -1);
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            Stack<Integer> sb = new Stack<>();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int plus = 0;
            while (i >= 0 || j >= 0) {
                int i1 = i < 0 ? 0 : (int) a.charAt(i) -48;
                int j1 = j < 0 ? 0 : (int) b.charAt(j) -48;
                int i2 = i1 + j1 + plus;
                sb.push(i2 % 2);
                plus = i2 / 2;
                i--;
                j--;
            }
            if (plus != 0) {

                sb.push(plus);
            }
            StringBuilder builder = new StringBuilder();
            while (!sb.isEmpty()) {
                builder.append(sb.pop());
            }
            return builder.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
