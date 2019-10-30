// 标题:
//      计数质数

// 描述:
//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学

// 思路:

/**
 * Created by huyanshi on 191029.
 *
 * 1. 暴力解法, 大家都会, 只要懂得质数的定义即可. 但是在本题里面, 这种解放的时间不能通过. O(n2)
 *
 * 2. 筛选法.
 *
 * 简单的筛选法的原理:  质数的倍数不是质数.
 *
 * 因此对于很多大数, 我们可以提前标记好, 而不用去计算他是否是质数,
 *
 * 我们在程序中保存一个 boolean 的数组(可以用位图实现), 代表 0-n 的每个位置是不是质数,
 *
 * 从2开始, 我们每发现一个质数, 就将 n 以内 该质数的倍数标记为不是质数.
 *
 * 这样对于很多的数字, 我们不用计算, 仅看标记就可以知道它是否是质数了.
 *
 * 时间复杂度符合要求. 为 O(nlogn)左右.
 *
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.BitSet;

public class LeetCode204 {
    public static void main(String[] args) {
        Solution solution = new LeetCode204().new Solution();
        System.out.println(solution.countPrimes(10));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes2(int n) {
            int j = 2;
            int ret = 0;
            while (j < n) {
                if (j > 2 && (j & 1) == 0) {
                    j++;
                    continue;
                }

                int i = 2;
                boolean flag = false;

                while (i <= Math.sqrt(j)) {
                    if ((j % i) == 0) {
                        flag = true;
                        break;
                    }
                    i++;
                }
                if (!flag) {
                    ret++;
                }

                j++;
            }
            return ret;
        }

        public int countPrimes(int n) {
            int ret = 0;
            BitSet bitmap = new BitSet();
            int j = 2;
            while (j < n) {
                if (!bitmap.get(j) && isP(j)) {
                    int i = 2;
                    while (i * j < n) {
                        bitmap.set(i * j);
                        i++;
                    }
                    ret++;
                }
                j++;
            }
            return ret;

        }

        public boolean isP(int n) {
            if (n > 2 &&(n & 1) == 0) return false;
            int j = 2;
            int sqrt = (int) Math.sqrt(n);
            while (j <= sqrt) {
                if ((n % j) == 0) {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
