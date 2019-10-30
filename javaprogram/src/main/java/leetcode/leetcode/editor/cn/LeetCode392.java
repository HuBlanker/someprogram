// 标题:
//      判断子序列

// 描述:
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划

// 思路:

/**
 * Created by huyanshi on  191023.
 *
 * 1. 暴力解法, 对每一个 s中的字符, 找 它 在t中的位置, 位置必须是递增的(保证顺序). 时间复杂度 O(st).
 *
 * 2.当数据量大量增加. 我们可以使用 对一直字符串建立"索引",外加二分查找的方式来解决性能问题.
 *
 *  首先, 我们读取一遍 字符串 t. 对其中的每个字母统计起出现位置, 得到类似于:
 *      a = [0,10,20,30]
 *      b = [1,2,34,5]
 *      ...
 *  的一份索引顺序,其中的数字代表着该字母每一次出现的位置.
 *
 *  之后对于 输入的 S. 我们 对每一个字符在 他的位置数组上进行二分查找, 寻找 大于 前一个字母出现位置的第一个位置.(贪心思想). 比如
 *
 *  输入了: abc.
 *
 *  那么首先二分查找a, 得到了结果 10, 之后 查找b的位置要求大于10. (满足子序列有序特征).
 *  查找到最后都存在在饭后ture, 否则是false.
 *
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode392{
       public static void main(String[] args) {
            Solution solution = new LeetCode392().new Solution();
           System.out.println(solution.isSubsquence10e("abc","abbbbbbbc"));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx = -1;
        for (char c : s.toCharArray()) {
            idx = t.indexOf(c, idx + 1);
            if (idx == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsquence10e(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.computeIfAbsent(chars[i], k -> new ArrayList<>()).add(i);
        }

        int tag = -1;
        for (int i = 0; i < s.length(); i++) {
            List<Integer> integers = map.get(s.charAt(i));
            int left = 0;
            int right = integers.size() - 1;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (integers.get(mid) > tag) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (integers.get(left) < tag  ) return false;
            tag = integers.get(left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
