// 标题:
//      二叉树的最小深度

// 描述:
//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

// 思路:

/**
 * 非递归解法, 广度优先遍历法,统计层数, 在第一次发现有"左右子节点都为空"的节点时, 返回当前深度,即使最小深度.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111 {
    public static void main(String[] args) {
        Solution solution = new LeetCode111().new Solution();

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


        System.out.println(solution.minDepth(ns[0]));
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
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int depth = 0;
            while (!q.isEmpty()) {
                ++depth;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = q.poll();
                    if (poll.left != null) {
                        q.offer(poll.left);
                    }
                    if (poll.right != null) {
                        q.offer(poll.right);
                    }
                    if (poll.left == null && poll.right == null) {
                        return depth;
                    }
                }
            }
            return depth;
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
