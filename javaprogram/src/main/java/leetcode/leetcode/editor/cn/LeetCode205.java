// 标题:
//      同构字符串

// 描述:
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表

// 思路:

/**
 * Created by huyanshi on 191029.
 * <p>
 * 按照题目中的要求, 使用hash表逐步实现即可.
 * <p>
 * 注意题目中的隐含意思: 字母间的对应关系是一对一也就是双向对应的, 因此一个hash表并不能保证这一点.
 * 需要正向反向两个hash表, 或者正向hash表, 而对value使用set保证不重复即可.
 * <p>
 * guava有一个工具包: {@link com.google.common.collect.BiMap} 实现了双向绑定的hash
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode205 {
    public static void main(String[] args) {
        Solution solution = new LeetCode205().new Solution();
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("ab", "aa"));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null && t == null) return true;
            Map<Character, Character> hash = new HashMap<>();
            Set<Character> vSet = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                Character v = hash.get(key);
                char t1 = t.charAt(i);
                if (v == null) {
                    hash.put(key, t1);
                    if (vSet.contains(t1)) {
                        return false;
                    }
                } else {
                    if (v != t1) {
                        return false;
                    }
                }
                vSet.add(t1);
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)


}
