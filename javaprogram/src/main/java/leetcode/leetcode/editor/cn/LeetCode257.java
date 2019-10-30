// 标题:
//      二叉树的所有路径

// 描述:
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索

// 思路:

/**
 * Created by huyanshi on  191017.
 * <p>
 * 递归法:
 * 树的问题很容易就能想到用递归求解.
 * 递归求解, 当前节点 不为叶子节点, 则把自己添加进结果, 然后递归左右子节点(不为空的话).
 * 如果是叶子节点(递归终止条件): 把当前的结果字符串保存下来. 这是一条路径.
 *
 * 迭代:
 * 迭代的话, 用广度优先遍历.
 * 给每一个节点保存 根节点到他的路径, 然后 如果是叶子节点的话 把自己的路径加到结果集里面就好了.
 *
 * 怎么计算每一个节点的路径? 层次遍历的时候,对遍历到的节点,都是知道他的父节点的(层次遍历就是每次放队列中的节点的子节点)
 * 所以就是 父节点的路径加上自己的值, 就是当前节点的路径咯.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode257 {
    public static void main(String[] args) {
        Solution solution = new LeetCode257().new Solution();
        TreeNode[] a = new TreeNode[10];
        a[0] = new TreeNode(1);
        a[1] = new TreeNode(2);
        a[2] = new TreeNode(3);
        a[3] = new TreeNode(5);

        a[0].left = a[1];
        a[0].right = a[2];
        a[1].right = a[3];

        System.out.println(solution.binaryTreePaths2(a[0]));
        System.out.println(solution.binaryTreePaths2(a[3]));

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
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<String> ret = new ArrayList<>();
            String sb = "";
            sb += root.val;

            if (root.left == null && root.right == null) {
                ret.add(sb);
            }
            forPath(root.left, sb, ret);
            forPath(root.right, sb, ret);
            return ret;
        }

        private void forPath(TreeNode root, String sb, List<String> ret) {
            if (root == null) return;
            sb += "->";
            sb += root.val;
            if (root.left == null && root.right == null) {
                ret.add(sb);
            }
            if (root.left != null) forPath(root.left, sb, ret);
            if (root.right != null) forPath(root.right, sb, ret);
        }

        public List<String> binaryTreePaths2(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<String> ret = new ArrayList<>(10);
            HashMap<TreeNode, String> paths = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            paths.put(root, String.valueOf(root.val));
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                String s = paths.get(poll);
                if (poll.left == null && poll.right == null) {
                    ret.add(paths.get(poll));
                }
                if (poll.left != null) {
                    q.offer(poll.left);
                    paths.put(poll.left, s + "->" + poll.left.val);
                }

                if (poll.right != null) {
                    paths.put(poll.right, s + "->" + poll.right.val);
                    q.offer(poll.right);
                }
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
