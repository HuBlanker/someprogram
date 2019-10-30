// 标题:
//      对称二叉树

// 描述:
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

// 思路:

/**
 * 题目里提到了, 可以使用递归和非递归的两种解法.
 * 递归的就是分别判断左右子树是否是对称的, 递归终止条件是: 左右有某一个或者2个都为空.
 *
 * 非递归的方式采用了层次遍历,
 *
 * 遍历两遍, 第一采用 父->左儿子->右儿子.  第二次是 父->右儿子->左儿子. 然后对两次遍历的结果进行比较.
 *
 * 注意,由于有空节点, 所有把空节点用-1填充来对比.
 */
// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode101 {
    public static void main(String[] args) {
        Solution solution = new LeetCode101().new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);

        n1.left = n2;
        n1.right = n3;
//
        System.out.println(solution.isSymmetric(n1));

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
        public boolean isSymmetric(TreeNode root) {
            List<Integer> r1 = left(root);
            List<Integer> r2 = right(root);

            if (r1.size() == r2.size()) {
                for (int i = 0; i < r1.size(); i++) {
                    if (!r1.get(i).equals(r2.get(i))) {
                        return false;
                    }
                }
                return true;

            }
            return false;

        }

        private List<Integer> right(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> ret = new ArrayList<>(10);
            Queue<TreeNode> q = new LinkedList<>();
            ret.add(root.val);
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                if (poll.right != null) {
                    q.offer(poll.right);
                    ret.add(poll.right.val);
                } else {
                    ret.add(-1);
                }
                if (poll.left != null) {
                    q.offer(poll.left);
                    ret.add(poll.left.val);
                } else {
                    ret.add(-1);
                }
            }
            return ret;
        }

        private List<Integer> left(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> ret = new ArrayList<>(10);
            Queue<TreeNode> q = new LinkedList<>();
            ret.add(root.val);
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.offer(poll.left);
                    ret.add(poll.left.val);
                } else {
                    ret.add(-1);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                    ret.add(poll.right.val);
                } else {
                    ret.add(-1);
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


