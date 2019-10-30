// 标题:
// 有效的括号

// 描述:
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

// 思路:

/**
 * 利用栈来操作,
 * 左括号入栈,右括号从栈顶弹出一个值,查看是否匹配,匹配则继续, 不匹配则直接false.
 * 需要注意:
 * 1. 在还有右括号等待匹配的情况下, 栈为空,会有emptyStack异常, 此时应该返回false.
 * 2. 循环结束, 栈不为空,说明有多的左括号,应该返回false.
 */
// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode20 {
    public static void main(String[] args) {
        Solution solution = new LeetCode20().new Solution();
        System.out.println(solution.isValid("{{}}"));
        System.out.println(solution.isValid("{(}}"));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) return true;
            Map<Character, Character> map = new HashMap<>(3);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    stack.push(c);
                }
                if (map.containsValue(c)) {
                    if (stack.isEmpty()) return false;
                    Character pop = stack.pop();
                    if (!map.get(pop).equals(c)) return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
