// 标题:
//      路径总和

// 描述:
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

// 思路:

/**
 * Created by pfliu on 19.10.09.
 *
 * 递归思想, 有没有路径和, 即, 和 - 自身的值 = 左子树的路径和 || 右子树的路径和.
 *
 * 递归停止条件: 左右子节点都为空, 这时候判断和和本身相等与否即可.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode112 {
    public static void main(String[] args) {
        Solution solution = new LeetCode112().new Solution();
        TreeNode[] a = new TreeNode[10];
        a[0] = new TreeNode(10);

        System.out.println(solution.hasPathSum(a[0],10));
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
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            int sum1 = sum - root.val;
            if (root.left == null && root.right == null) return sum - root.val == 0;
            return hasPathSum(root.left, sum1) || hasPathSum(root.right, sum1);
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
