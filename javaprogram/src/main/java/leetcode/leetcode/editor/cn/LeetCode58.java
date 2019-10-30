// 标题:
//      最后一个单词的长度

// 描述:
//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串

// 思路:

/**
 * 这个题很简单... 按照各自的思路来吧, 主要是考虑到各种bad case. 比如结尾带空格等等...
 * 可以调用各种API来完成.也可以自己遍历一遍char.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.jar.JarEntry;

public class LeetCode58 {
    public static void main(String[] args) {
        Solution solution = new LeetCode58().new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("a "));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) return 0;
            s = s.trim();
            int j = s.length() - 1;
            for (; j >= 0; j--) {
                if (s.charAt(j) == ' ') return s.length() - 1 - j;
            }
            return s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
