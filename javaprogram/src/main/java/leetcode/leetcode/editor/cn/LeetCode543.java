// 标题:
//      二叉树的直径

// 描述:
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。 
//
// 示例 : 
//给定二叉树 
//
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树

// 思路:

/**
 * Created by huyanshi on 191015
 *
 * 求二叉树的最远距离节点间的节点.
 *
 * 首先总结几个规律:
 * 1. 一棵树的直径要么完全在其左子树中,要么完全在其右子树中, 要么路过根节点.
 * 2. 一棵树的直径 = 以该树中每一个节点为根节点, 求 路过根节点的最大直径, 所有节点的最大值就是这棵树的直径.
 * 3. 求经过根节点的直径, 可以分解为: 求左子树的最深叶子 + 右子树的最深叶子.
 *
 * 所以我们要做:
 *
 * 1. 递归的求 每一个节点的  **路过根节点的直径(求当前节点的左子树最深叶子和右子树的最深叶子)**,取其最大值.
 * 2. 求某一个节点的最深叶子, 就等于 他的 左子树最深叶子 + 1 和 右子树最深叶子 + 1 的较大值.
 * 3. 在求最深叶子的时候, 其实是求出了当前节点直径的(左边最深叶子 + 右边最深叶子 + 2), 为了避免重复计算, 我们在递归求最深叶子的时候, 把直径也记录下来.)
 *
 *
 * 所以最终:
 *
 * 我们求根节点的直径, 会递归的计算每一个节点最深叶子, 也就求出了每一个节点的直径, 对所有的直径取最大返回即可.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.concurrent.atomic.AtomicReference;

public class LeetCode543{
       public static void main(String[] args) {
            Solution solution = new LeetCode543().new Solution();
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicReference<Integer> ret = new AtomicReference<>(0);
         find(root, ret);
        return ret.get();
    }

    private int find(TreeNode node, AtomicReference<Integer> result) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.left != null) left = find(node.left,result) + 1;
        if (node.right != null) right = find(node.right,result) + 1;
        int tmp = Math.max(result.get(), left + right);
        result.set(tmp);
        return Math.max(left, right);
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
