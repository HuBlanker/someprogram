// 标题:
// 罗马数字转整数

// 描述:
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串

// 思路:
/**
 * 看完题目发现, 有个基本规律, 从左到右是依次减小的, 除了那六种情况.
 * 所以把输入转成array, 然后依次遍历,
 * 如果当前值大于等于下一个值,类似于"D" > "I". 那么直接给结果加"D".
 * 如果当前值小于, 则说明命中了六种规则,
 * 取当前位和下一位, 给结果加上 "下一位 - 当前位"
 * 注意这里当命中的时候, 依次取了两位, 循环多跳一格.
 */
// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {
    public static void main(String[] args) {
        Solution solution = new LeetCode13().new Solution();
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IIII"));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>(7);
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            char[] chars = s.toCharArray();
            int ret = 0;
            for (int i = 0; i < chars.length; i++) {
                if (i < chars.length - 1) {
                    if (map.get(chars[i]) >= map.get(chars[i + 1])) {
                        ret += map.get(chars[i]);
                    } else {
                        ret += (map.get(chars[i + 1]) - map.get(chars[i]));
                        i++;
                    }
                } else {
                    ret += map.get(chars[i]);

                }
            }
            return ret;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
