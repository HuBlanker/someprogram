// 标题:
//      阶乘后的零

// 描述:
//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学

// 思路:

/**
 * Created by huyanshi on 191021. 总体的思路就是找 1-n中有多少个质因数为5.
 * <p>
 * 1. 遍历 1-n. 求每一个数是否是5的倍数. 然后对5的倍数, 5的次幂进行相加.
 * 2. n / 5 , 代表 有多少个5个一组的, 5个一组的必然有一个5, n/ 25  代表有多少个25个一组的. 代表着有一个 5 的平方, 需要多加一个0. 然后是125....知道n < 5的x次幂.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode172 {
    public static void main(String[] args) {
        Solution solution = new LeetCode172().new Solution();
        System.out.println(solution.trailingZeroes2(5));
        System.out.println(solution.trailingZeroes2(25));
        System.out.println(solution.trailingZeroes2(30));

    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes2(int n) {
            if (n <= 0) return 0;
            int ret = 0;
            for (int i = 1; i <= n; i++) {
                int tmp = i;
                while ((tmp % 5) == 0) {
                    ret++;
                    tmp /= 5;
                }
            }
            return ret;
        }

        public int trailingZeroes(int n) {
            if (n <= 0) return 0;
            int ret = 0;
            int a = 1;
            while (n >= Math.pow(5, a)) {
                ret += (n / Math.pow(5, a));
                a++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
