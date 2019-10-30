// 标题:
//      求众数

// 描述:
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

// 思路:

/**
 * Created by huyanshi on 191021.
 *
 * 1. hash表, 直接计数. O(N)
 * 2. 排序,然后在中间的那个数字就是众数. 排序问题, 最好O(N).
 * 3. 随机, 随机选一个下标, 然后监测他是不是众数.
 * 4. 分治: 左边一半的众数, 和右边一半的众数. 可以得到全局的众数. 因此可以分治法来搞定. O(NlogN)
 * 5. Boyer-Moore 投票算法. 如果我们把众数记为+1, 把其他数记为−1，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
 *      所以我们可以依次遍历, 假设一个候选的众数,然后+1,-1, 如果为0 , 说明前面的结果可以全部忘记, 重新开始. 时间O(N),空间O(1).
 *      代码见下方: majorityElement5(int[] nums).
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.HashMap;
import java.util.Map;

public class LeetCode169{
       public static void main(String[] args) {
            Solution solution = new LeetCode169().new Solution();
           System.out.println(solution.majorityElement5(new int[]{3,2,3}));
           System.out.println(solution.majorityElement5(new int[]{2,2,1,1,1,2,2}));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> index = new HashMap<>(10);
        for (int num : nums) {
            Integer old = index.getOrDefault(num, 0);
            index.put(num, old + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : index.entrySet()) {
            if (integerIntegerEntry.getValue() > (nums.length >> 1)) {
                return integerIntegerEntry.getKey();
            }
        }
        return 0;
    }

    public int majorityElement5(int[] ints) {
        int ret = 0;
        int curNum = 0;
        for (int anInt : ints) {
            if (ret == 0) {
                curNum = anInt;
            } else if (curNum == anInt) {
                ret++;
            } else {
                ret--;
            }
        }
        return curNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
