// 标题:
// 最长公共前缀

// 描述:
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

// 思路:
/**
 * 简化为两两求最长公共前缀,之后用前缀和下一个字符串求前缀即可.
 * 求前缀: 用一个指针依次向后移动,两个位置相等则OK,不相等则停止. 然后返回0-X的子串.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode14 {
    public static void main(String[] args) {
        Solution solution = new LeetCode14().new Solution();
        String[] a = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(a));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String pre = strs[0];
            for (int i = 1; i < strs.length; i++) {
                pre = findPre(pre, strs[i]);
            }
            return pre;
        }

        public String findPre(String s1, String s2) {
            int i = 0;
            while (i < s1.length() && i < s2.length()) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }
            return s1.substring(0, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
