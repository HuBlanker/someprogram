// 标题:
//      快乐数

// 描述:
//编写一个算法来判断一个数是不是“快乐数”。 
//
// 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。 
//
// 示例: 
//
// 输入: 19
//输出: true
//解释: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学

// 思路:

/**
 * Created by huyanshi on 191017.
 *
 * 这题重点在思路, 很明显要使用循环, 当拿到的值为1时, 是正确的退出循环. true的情况.
 *
 * 那么 false 的情况下怎么退出循环? 有向无环图的问题. 如果这个数所经历的数字路径上有环, 那么就说明不可能是快乐数了.
 *
 * 那么题目就变成了找到路径中的环.
 *
 * 1. 哈希表, 总之就是保存所有走过的路径, 看一下是否有重复, 有重复就是环了.
 * 2. 快跑指针, 慢的跑一格, 快的跑两格. 如果有环, 他们两个迟早会相遇的.
 *
 *
 * 找到环之后, 如果环的重合点是1, 那么就是快乐数.
 *
 * 如果不是1. 那就不是快乐数.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.ArrayList;
import java.util.List;

public class LeetCode202{
       public static void main(String[] args) {
            Solution solution = new LeetCode202().new Solution();
           System.out.println(solution.isHappy2(19));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        List<Integer> graph = new ArrayList<>(10);
        while (!graph.contains(n)) {
            if (n == 1) {
                return true;
            }
            graph.add(n);

            n = getDoubleSUm(n);
        }
        return false;
    }

    public int getDoubleSUm(int n) {
        List<Integer> bit = new ArrayList<>();
        while (n != 0) {
            bit.add(n % 10);
            n /= 10;
        }
        int ret = 0;
        for (Integer integer : bit) {
            ret += integer * integer;
        }
        return ret;
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getDoubleSUm(n);
        while (slow != fast) {
            slow = getDoubleSUm(slow);
            fast = getDoubleSUm(fast);
            fast = getDoubleSUm(fast);
        }
        return slow == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
