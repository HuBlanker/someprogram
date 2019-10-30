// 标题:
//      Excel表列序号

// 描述:
//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学

// 思路:

/**
 * Created by huyanshi on 26 进制转换成10进制.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import javax.swing.*;

public class LeetCode171{
       public static void main(String[] args) {
            Solution solution = new LeetCode171().new Solution();
           System.out.println(solution.titleToNumber("AB"));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String s) {

        int i = s.length() - 1;

        int ret = 0;
        for (int i1 = 0; i1 < s.toCharArray().length; i1++) {
            int i2 = s.charAt(i1) - 'A' + 1;
            ret += Math.pow(26, i) * i2;
            i--;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
