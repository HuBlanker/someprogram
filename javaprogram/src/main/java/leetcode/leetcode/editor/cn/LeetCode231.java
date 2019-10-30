// 标题:
//      2的幂

// 描述:
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

// 思路:

/**
 * Created by huyanshi on 191020
 * 2 的倍数 ,  他的二进制里, 只能有一个1. 直接 对 二进制求 1 的个数, 就好了.
 * <p>
 * 求二进制中1的个数, 可以调用Integer.bitCount(),它是常熟时间复杂度.
 * <p>
 * 回忆一下4的次幂: 先判断是不是2的次幂, 然后 再将数字 和 0x5555555555, 进行&操作, 判断一下他的1在奇数位置还是偶数位置.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode231 {
    public static void main(String[] args) {
        Solution solution = new LeetCode231().new Solution();
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo2(int n) {
            if (n <= 0) return false;
            return Integer.bitCount(n) == 1;
        }

        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
