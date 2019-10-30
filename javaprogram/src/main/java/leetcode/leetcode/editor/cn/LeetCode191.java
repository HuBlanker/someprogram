// 标题:
//      位1的个数

// 描述:
//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。 
//
// 
//
// 示例 1： 
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。 
// 
//
// 
//
// 进阶: 
//如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算

// 思路:

/**
 * Created by huyanshi on 191018.
 *
 * 有 O(n) , n是bit位数. 每次右移一位, 看看最后一位是不是1. 最简单粗暴, 效率也还行.
 *
 * 有 O(n)的, n是bit为1的个数. 用 n & n -1 每次消除最后一个1, 只需要循环1的个数就可以.
 *
 * 还有java.lang.Integer#bitCount(int)的实现, O(1). 通过` i = (i & 0x55555555) + ((i >>> 1) & 0x55555555);` 在O(1)内获得每两个bit的1的数量.
 * 然后 两两相加得到4个bit上1的个数, 然后两两相加得到8位, 16, 32 位, 结束. 一直进行与运算,而且次数固定, 所以是O(1).
 *
 * 不断进行上面那个式子, 可以拿到x为的 低/高 x/2位的个数, 加起来就是x位里面的总个数.
 *
 *
 * https://segmentfault.com/a/1190000015763941 , 这里讲的特别好.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode191{
       public static void main(String[] args) {
            Solution solution = new LeetCode191().new Solution();
           System.out.println(solution.hammingWeight(767));
           System.out.println(19 >>>1);
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
