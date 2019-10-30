// 标题:
//      键盘行

// 描述:
//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * 按照题目进行判断,:
 *  1. 首先求出每一个字母所在的行,
 *  2. 判断一个单词中的所有字母是不是再同一行, 这个可以直接 用 每一个字符的行等于上一个字符的行.
 *  3. 去掉不在同一行的字符串.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import sun.font.TrueTypeFont;
import thrift_demo.UserService;

import java.util.*;

public class LeetCode500 {
    public static void main(String[] args) {
        Solution solution = new LeetCode500().new Solution();
        System.out.println(Arrays.toString(solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            if (words == null || words.length == 0) return new String[0];
            List<String> ret = new ArrayList<>();
            for (String word : words) {
                if (isSameLevel(word)) ret.add(word);
            }
            return ret.toArray(new String[0]);

        }

        public boolean isSameLevel(String s) {
            int[] a = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                a[i] = location(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i++) {
                if (a[i] != a[i - 1]) {
                    return false;
                }
            }
            return true;
        }

        public int location(char a) {
            List<Character> characters = Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P');
            List<Character> characters1 = Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
            List<Character> characters2 = Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L');
            List<Character> characters3 = Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
            List<Character> characters4 = Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M');
            List<Character> characters5 = Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm');

            if (characters.contains(a) || characters1.contains(a)) {
                return 1;
            }
            if (characters2.contains(a) || characters3.contains(a)) {
                return 2;
            }
            return 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
