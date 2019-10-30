// 标题:
//      学生出勤记录 I

// 描述:
//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。 
//
// 示例 1: 
//
// 输入: "PPALLP"
//输出: True
// 
//
// 示例 2: 
//
// 输入: "PPALLL"
//输出: False
// 
// Related Topics 字符串

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * kkk按照题意正常写就行.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import sun.font.TrueTypeFont;

import javax.sound.midi.Track;

public class LeetCode551{
       public static void main(String[] args) {
           Solution solution = new LeetCode551().new Solution();
           System.out.println(solution.checkRecord("AAA"));
           System.out.println(solution.checkRecord("PPALLP"));
           System.out.println(solution.checkRecord("PPALLL"));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkRecord(String s) {
        boolean isA = false;
        int acnt = 0;
        boolean isL = false;
        int nowL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                acnt += 1;
                if (acnt > 1) {
                    isA = true;
                }
                nowL = 0;
                continue;
            }
            if (s.charAt(i) == 'L') {
                nowL++;
                if (nowL > 2) {
                    isL = true;
                }
                continue;
            }
            nowL = 0;
        }
        return !(isA || isL);
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
