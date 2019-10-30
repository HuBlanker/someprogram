// 标题:
//      二叉树的坡度

// 描述:
//给定一个二叉树，计算整个树的坡度。 
//
// 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。 
//
// 整个树的坡度就是其所有节点的坡度之和。 
//
// 示例: 
//
// 
//输入: 
//         1
//       /   \
//      2     3
//输出: 1
//解释: 
//结点的坡度 2 : 0
//结点的坡度 3 : 0
//结点的坡度 1 : |2-3| = 1
//树的坡度 : 0 + 0 + 1 = 1
// 
//
// 注意: 
//
// 
// 任何子树的结点的和不会超过32位整数的范围。 
// 坡度的值不会超过32位整数的范围。 
// 
// Related Topics 树

// 思路:

/**
 * Created by huyanshi on 191025.
 *
 * 这道题一看就是可以用递归思想来解决的. 那么按照如下思路:
 *
 * 1. 用递归的话.
 * 2. 我们需要求出每一个节点的 坡度 然后相加.
 * 3. 为了求出坡度, x(坡度) = (x.leftSum - x.rightSum)abs
 * 4. 那么我们需要求出每一个节点的  (所有节点的和). 这个过程中无疑是存在重复计算的, 想办法避免一下.
 *
 * 需要明确一下, 我们要求得最终值 是 对于每一个节点的 坡度, 只要拿到相加即可. 对于每一个节点的 节点总和, 最好可以递归传递,
 * 因为最底层的节点的节点总和, 需要使用多次.
 *
 * 因此将 节点总和 作为返回值, 坡度用全局变量保存, 不断相加即可.
 *
 * 具体代码及注释如下.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode563 {
    public static void main(String[] args) {
        Solution solution = new LeetCode563().new Solution();

        TreeNode[] a = new TreeNode[10];
        a[0] = new TreeNode(1);
        a[1] = new TreeNode(2);
        a[2] = new TreeNode(3);

        a[0].left = a[1];
        a[0].right = a[2];
        System.out.println(solution.findTilt(new TreeNode(10)));
        System.out.println(solution.findTilt(a[0]));
    }


// My Code End


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int findTilt(TreeNode root) {
            if (root == null) return 0;
            // 坡度
            AtomicInteger ret = new AtomicInteger(0);
            find(root, ret);
            return ret.get();
        }

        private int find(TreeNode root, AtomicInteger ret) {
            // 如果节点为空 ,没有坡度, 节点总和为0
            if (root == null) return 0;
            // 如果是叶子节点, 坡度为0 , 节点总和为自身的值
            if (root.left == null && root.right == null) {
                ret.set(ret.get());
                return root.val;
            }
            int left = find(root.left, ret);
            int right = find(root.right, ret);
            // 如果是一个普通的非叶子节点, 那么对 总的坡度 加上 当前节点的坡度.
            ret.set(ret.get() + Math.abs(left - right));
            // 当前节点的 节点总和 = 左子树的节点总和 + 右节点的 + 自身的值.
            return left + right + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
