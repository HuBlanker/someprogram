// 标题:
//      二叉树的层次遍历 II

// 描述:
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索

// 思路:

/**
 * 按照层次遍历的思路来搞, 把每一个按照左子树右子树的顺序入队,然后逐个出队即可.
 *
 * 需要注意的是, 此题里面需要进行分层,而普通的层次遍历是没有分层次的.
 *
 * 分层的办法, 每次直接读取队列中的所有节点,将他们的子节点全部入队. 然后再次读取队列中的全部节点.
 *
 * 因为当第一层的最后一个节点遍历完, 此时队列中的所有节点都是第二层的, 我们只需记录下这个数字即可区分层次.
 *
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode107 {
    public static void main(String[] args) {
        Solution solution = new LeetCode107().new Solution();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        System.out.println(solution.levelOrderBottom(n1));
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>(10);
            if (root == null) return new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                List<Integer> level = new ArrayList<>(10);
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = q.poll();
                    if (poll == null) continue;
                    level.add(poll.val);
                    if (poll.left != null) q.offer(poll.left);
                    if (poll.right != null) q.offer(poll.right);
                }
                ret.add(0, level);
            }
            return ret;
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
