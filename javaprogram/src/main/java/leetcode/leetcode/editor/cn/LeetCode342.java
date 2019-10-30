// 标题:
//      4的幂

// 描述:
//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。 
//
// 示例 1: 
//
// 输入: 16
//输出: true
// 
//
// 示例 2: 
//
// 输入: 5
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 位运算

// 思路:

/**
 * Created by huyanshi on 191017.
 * <p>
 * 解法1: 循环递归, 整除和取余操作计算.
 * <p>
 * 解法2:
 *  2的幂都是 1000000000,这样子的.
 *  4的幂是在2的幂的基础上, 只有奇数位的才可以是1, 比如 4=100. 16 = 10000.
 *  那么 4的幂次方 & 0xaaaaaaaa 肯定等于0. 因为0xaaaaaaaa在偶数位上为1, 在奇数上为0.
 *  所以用上面的公式加上 限制数字中只有一个1就可以保证它是4的幂了.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import javax.sound.midi.Soundbank;

public class LeetCode342 {
    public static void main(String[] args) {
        Solution solution = new LeetCode342().new Solution();
        System.out.println(solution.isPowerOfFour(16));
    }


// My Code End


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int num) {
            while (num != 0 && num % 4 == 0) {
                num /= 4;
            }
            return num == 1;
        }

        public boolean isPowerOfFour2(int num) {
            if ((num & 0xaaaaaaaa) == 0 && Integer.bitCount(num) == 1) return true;
            else return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
