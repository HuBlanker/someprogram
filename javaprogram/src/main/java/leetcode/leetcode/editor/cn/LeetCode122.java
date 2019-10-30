// 标题:
//      买卖股票的最佳时机 II

// 描述:
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 贪心算法 数组

// 思路:

/**
 * Created by huyanshi on 191010
 *
 *  直接拿到每天的收益, 正数直接相加即可.
 *
 *  因为如果是连续的上升, 那么每个收益相加和直接的收益是一样的.
 *
 *  如果中断掉, 那么相当于在最后一个上升日后卖掉.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode122{
       public static void main(String[] args) {
            Solution solution = new LeetCode122().new Solution();
           System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
           System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
           System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length -1; i++) {
            int i1 = prices[i + 1] - prices[i];
            if (i1 > 0)
                sum += i1;

        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
