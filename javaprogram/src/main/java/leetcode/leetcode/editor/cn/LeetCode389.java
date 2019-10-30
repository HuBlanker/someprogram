// 标题:
//      找不同

// 描述:
//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表

// 思路:

/**
 * Created by huyanshi on 191023.
 *
 * 1. 和求异位词的方法一样, 先对两个字符串进行排序, 然后逐个对比, 第一个和源字符串不一样的字符就是添加进来的字符.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode389{
       public static void main(String[] args) {
            Solution solution = new LeetCode389().new Solution();
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != chars1[i]) {
                return chars1[i];
            }
        }
        return chars1[chars.length];
    }

}
//leetcode submit region end(Prohibit modification and deletion)



}
