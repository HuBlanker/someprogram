// 标题:
//      字符串中的单词数

// 描述:
//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
// 
// Related Topics 字符串

// 思路:

/**
 * Created by huyanshi on 191017
 *
 * 解法1:
 * 按照题目描述编码, 遍历字符串, 如果是空格,则简单当前空格前面是否有单词, (用变量记住), 如果有,则总单词数量加1. 如果当前位置不是空格, 则单词长度加1.
 *
 * 挺好理解的, 也挺好想到的.
 *
 * 解法2:
 * 统计 单词开始 的个数即可.
 * 单词开始的定义: 如果当前字符的前一个字符是空格,或者是字符串的开始, 且自己不是个空格, 那么就是一个单词的开始.
 *
 * 统计字符串中满足上面定义的字符的个数, 就是单词的个数.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode434{
       public static void main(String[] args) {
            Solution solution = new LeetCode434().new Solution();
           System.out.println(solution.countSegments2(" hello, my name is pf"));
           System.out.println(solution.countSegments2(" "));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int wordLength = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (wordLength != 0) {
                    count++;
                    wordLength = 0;
                }
                continue;
            } else {
                wordLength++;
            }
        }
        if (wordLength > 0 ) count++;
        return count;
    }
    public int countSegments2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
