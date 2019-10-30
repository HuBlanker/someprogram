// 标题:
//      检测大写字母

// 描述:
//给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * 直接按照题意分析, 写ifelse即可.
 *
 * 统计长度比一个一个监测是不是大写要方便一点. 总的来说还是一道找规律的题.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode520{
       public static void main(String[] args) {
            Solution solution = new LeetCode520().new Solution();
           System.out.println(solution.detectCapitalUse("USA"));
           System.out.println(solution.detectCapitalUse("leetcode"));
           System.out.println(solution.detectCapitalUse("Google"));
           System.out.println(solution.detectCapitalUse("ADDDc"));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0 ) return true;
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        if (count == word.length() || count == 0) return true;
        if (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
