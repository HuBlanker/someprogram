// 标题:
//      Excel表列名称

// 描述:
//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学

// 思路:

/**
 * Created by huyanshi on 191022.
 *
 * 本质上是求 10进制转换成26进制, 但是在这道题里, 26 = Z 而不是 A0. 所以需要额外处理这一个情况即可.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode168 {
    public static void main(String[] args) {
        Solution solution = new LeetCode168().new Solution();
        System.out.println(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(28));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuffer sb = new StringBuffer();
            while (n > 0) {
                int k = n % 26;
                if (k == 0) {
                    n -= 26;
                    k = 26;
                }

                char c = (char) ((k - 1) + (int) 'A');
                sb.insert(0, c);
                n = n / 26;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
