// 标题:
//      最长特殊序列 Ⅰ

// 描述:
//给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。 
//
// 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。 
//
// 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。 
//
// 示例 : 
//
// 输入: "aba", "cdc"
//输出: 3
//解析: 最长特殊序列可为 "aba" (或 "cdc")
// 
//
// 说明: 
//
// 
// 两个字符串长度均小于100。 
// 字符串中的字符仅含有 'a'~'z'。 
// 
// Related Topics 字符串

// 思路:

/**
 * Created by huyanshi on 19116.
 *
 * 如果两个字符串完全相等, 那就是没有独有子串, 返回-1.
 * 否则返回较长的那个的长度. 因为长的肯定是独有的.
 * 当两个长度相等, 但是内容不一样的时候, 互相都是独有的,所以返回一个长度就行.
 *
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode521{
       public static void main(String[] args) {
            Solution solution = new LeetCode521().new Solution();
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
