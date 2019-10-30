// 标题:
//      爬楼梯

// 描述:
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

// 思路:

/**
 * 直接递归比较简单, 但是超时了.
 * 所以用动态规划, 一直记录当前数字前面的两个数字. 不断向后移动即可.
 */

// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import com.sun.org.apache.bcel.internal.generic.I2B;

public class LeetCode70{
       public static void main(String[] args) {
            Solution solution = new LeetCode70().new Solution();
           System.out.println(solution.climbStairs(2));
           System.out.println(solution.climbStairs(3));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        return f(n);
    }

    public int f(int x) {
        if (x == 2) return 2;
        if (x == 1) return 1;
        int j1 = 1; int j2=2;
        for (int i = 3; i <= x; i++) {
            int tmp = j1 + j2;
            j1 = j2;
            j2 = tmp;
        }
        return j2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
