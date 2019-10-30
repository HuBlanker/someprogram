// 标题:
//      下一个更大元素 I

// 描述:
//给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于num1中的数字2，第二个数组中的下一个较大数字是3。
//    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
// 
//
// 注意: 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * 1. 没有使用栈.
 *      1. 首先用hash表存下来nums2中每个数字的index.
 *      2. 对Nums中间的每一个值进行搜索, 从他在hash表中的起始idex找到结束, 找到则填写,找不到则-1.
 *
 * 2. 利用单调栈.
 *      1. 单调栈的性质是: 战力的元素按照升序或者降序排列.
 *      2. 当新加入一个元素, 我们想保持单调栈的性质, 那么就需要调整,
 *      3. 调整过程就是 和栈顶元素对比,(假设是一个栈顶最小的单调栈)
 *      4. 如果当前元素大于栈顶元素, 那么就需要出栈,知道栈顶元素大于 当前元素((这在本题里面就找到了大于当前元素的第一个元素了))
 *      5. 如果当前元素小于栈顶元素, 直接进栈也可以保持单调栈的性质了.
 *
 *  关于本题的详细注释在代码里.
 *
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import com.mysql.fabric.proto.xmlrpc.InternalXmlRpcMethodCaller;

import java.util.*;

public class LeetCode496{
       public static void main(String[] args) {
            Solution solution = new LeetCode496().new Solution();
           System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
           System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
           System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2,4}, new int[]{2,4})));
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        Map<Integer, Integer> indx = new HashMap<>(10);
        for (int i = 0; i < nums2.length; i++) {
            indx.put(nums2[i], i);
        }
        for (int j = 0; j< nums1.length; j++) {
            int idx = indx.get(nums1[j]);
            for (int i1 = idx; i1 < nums2.length; i1++) {
                if (nums2[i1] > nums1[j]) {
                    ret[j] = nums2[i1];
                    break;
                }
                if (i1 == nums2.length - 1) {
                    ret[j] = -1;
                }
            }
        }
        return ret;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        // 求出nums2中每个元素的下一个最大元素
        Map<Integer, Integer> indx = new HashMap<>(10);

        Stack<Integer> s = new Stack<>();
        // 倒着入栈
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 如果当前元素大于栈顶元素, 那就把栈顶元素抛弃
            if (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            // 这时候栈顶元素就是 大于当前元素的第一个了. 作为结果存起来
            int tmp = s.isEmpty() ? -1 : s.peek();
            indx.put(nums2[i], tmp);
            s.push(nums2[i]);
        }

        // indx 里面存储了nums2 中每个元素右边的大于该元素的第一个元素.
        // 所以我们用nums1来取一遍就可以拿到结果了.
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = indx.get(nums1[i]);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
