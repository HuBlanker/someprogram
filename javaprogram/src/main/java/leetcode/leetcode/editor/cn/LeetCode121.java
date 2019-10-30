// 标题:
//      买卖股票的最佳时机

// 描述:
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。 
//
// 注意你不能在买入股票前卖出股票。 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

// 思路:

/**
 * Created by huyanshi on 191010
 *
 * 这道题其实和 #53# 题一样, 是求最大子序和.
 *
 * 不过这里的子序列并不是输入数列, 而是 输入数据两两相减得到, 即当前买,下一天卖掉的收益的序列.
 *
 * 如果当天的收益小于0, 那么不妨直接抛弃掉, 取下一天的收益. 用变量不断记录最大收益即可.
 *
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode121{
       public static void main(String[] args) {
            Solution solution = new LeetCode121().new Solution();
           System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            sum += (prices[i + 1] - prices[i]);
            if (sum < 0) sum = 0;
            else max = Math.max(sum, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
