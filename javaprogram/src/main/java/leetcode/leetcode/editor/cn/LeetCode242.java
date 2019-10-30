// 标题:
//      有效的字母异位词

// 描述:
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

// 思路:

/**
 * Created by huyanshi on 191023.
 *
 * 1. 字符是有大小顺序的, 所以把字符串 的所有字符进行排序, 变位词排序之后的序列应该是完全一样的.
 * 这样子搞的 时间复杂度 是排序的 O(NlogN) , 空间也是排序的 O(1).
 *
 * 2. hash表, 统计字符及其出现的次数.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.Arrays;

public class LeetCode242{
       public static void main(String[] args) {
            Solution solution = new LeetCode242().new Solution();
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if (chars1.length == chars2.length) {
            int i = 0;
            while (i < chars1.length) {
                if (chars1[i] != chars2[i]) {
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
