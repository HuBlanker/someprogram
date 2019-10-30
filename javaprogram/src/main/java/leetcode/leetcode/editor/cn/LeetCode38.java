// 标题:
//      报数

// 描述:
//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。 
//
// 注意：整数顺序将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
// 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
// 
// Related Topics 字符串

// 思路:

/**
 * 不管输入多少, 都是从1开始循环调用的. 第一次的结果是第二次的输入.
 * 报数的过程是一个统计的过程,统计连续的相等的数字个数, 然后将个数和数字本身拼接到结果中即可/
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode38 {
    public static void main(String[] args) {
        Solution solution = new LeetCode38().new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(29));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            String s = "1";
            for (int i = 2; i <= n; i++) {
                s = say(s);
            }
            return s;
        }

        private String say(String s) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder(s.length());
            int count = 1;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]) {
                    count += 1;
                } else {
                    sb.append(count).append(chars[i]);
                    count = 1;
                }
            }
            sb.append(count).append(chars[chars.length - 1]);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
