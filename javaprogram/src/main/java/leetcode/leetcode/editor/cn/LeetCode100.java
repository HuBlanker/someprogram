// 标题:
//      相同的树

// 描述:
//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索

// 思路:

/**
 * 深度优先遍历二叉树, 前序,中序,后序的遍历方式,又分别分为递归方法和非递归的方法.
 * 这里用了递归方法, 下次遇到遍历二叉树写一下非递归的办法.
 *
 * 需要注意是的题目中的第二种情况,也就是区分左子树和右子树,
 *
 * 当然不是真的区分,而是把空位用-1补齐就好了.
 *
 * 然后把遍历的结果对比一遍就好了.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.ArrayList;
import java.util.List;

public class LeetCode100 {
    public static void main(String[] args) {
        Solution solution = new LeetCode100().new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);

        n1.left = n2;
//        n1.right = n3;

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(1);

//        n4.left = n6;
        n4.right = n5;

        System.out.println(solution.isSameTree(n1, n4));
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            List<Integer> ret = new ArrayList<>(10);
            every(p, ret);

            List<Integer> re1 = new ArrayList<>(10);
            every(q, re1);

            if (ret.size() == re1.size()) {
                for (int i = 0; i < ret.size(); i++) {
                    if (ret.get(i).equals(re1.get(i))) {
                    } else {
                        return false;
                    }
                }
                return true;
            } else return false;
        }

        private void every(TreeNode p, List<Integer> ret) {
            if (p == null) {
                return;
            }
            ret.add(p.val);

            if (p.left != null) {
                every(p.left, ret);
            } else ret.add(-1);
            if (p.right != null) {
                every(p.right, ret);
            } else {
                ret.add(-1);
            }
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
