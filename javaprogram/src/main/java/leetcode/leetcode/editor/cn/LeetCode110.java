// 标题:
//      平衡二叉树

// 描述:
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
// Related Topics 树 深度优先搜索

// 思路:

/**
 * 用递归的方法,对每一个节点求左右子树的高度,相减., 然后分别查看左右子树是否平衡.
 *
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode110 {
    public static void main(String[] args) {
        Solution solution = new LeetCode110().new Solution();
        TreeNode[] ns = new TreeNode[10];
        ns[0] = new TreeNode(3);
        ns[1] = new TreeNode(3);
        ns[2] = new TreeNode(3);
        ns[3] = new TreeNode(3);
        ns[4] = new TreeNode(3);

        ns[0].left = ns[1];
        ns[0].right = ns[2];

        ns[2].left = ns[3];
        ns[2].right = ns[4];

        System.out.println(solution.isBalanced(ns[0]));
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

        }

        private int depth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(depth(root.left), depth(root.right)) + 1;
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
