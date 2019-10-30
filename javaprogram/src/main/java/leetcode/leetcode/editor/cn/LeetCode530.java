// 标题:
//      二叉搜索树的最小绝对差

// 描述:
//给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。 
//
// 示例 : 
//
// 
//输入:
//
//   1
//    \
//     3
//    /
//   2
//
//输出:
//1
//
//解释:
//最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 注意: 树中至少有2个节点。 
// Related Topics 树

// 思路:

/**
 * Created by huyanshi on 191016.
 * <p>
 * 解法1(粗暴的解法):
 * 首先对树进行层次遍历, 拿到的结果进行排序, 之后两两相减取绝对值, 拿到最小的一个绝对值差.
 * 时间复杂度 : 遍历树 O(n), 排序 O(nlogn), 最后 相减 O(n), 算法是: O(nlogn).
 * 空间复杂度: O(n). 保存了一份层次遍历的结果.
 * <p>
 * 解法2:
 * 解法1其实是有一个题目中的条件没有用到的, 那就是这是一棵二叉搜索树.
 * BST 的特性是: 左子树的值都小于根节点, 右子树的值都大于根节点.
 * 那么中序遍历的结果就是有序的, 就不用我们自己进行排序了.
 * <p>
 * 中序遍历过程中, 前一个节点就是 有序列表中当前节点左边的值, 所以保存前一个节点不断进行相减即可.
 * 代码见 {@link  getMinimumDifference2}
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class LeetCode530 {
    public static void main(String[] args) {
        Solution solution = new LeetCode530().new Solution();
        TreeNode[] a = new TreeNode[10];
        a[0] = new TreeNode(1);
        a[1] = new TreeNode(5);
        a[2] = new TreeNode(3);
        a[0].right = a[1];
        a[1].left = a[2];

        System.out.println(solution.getMinimumDifference(a[0]));
        System.out.println(solution.getMinimumDifference2(a[0]));


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
        public int getMinimumDifference(TreeNode root) {
            List<Integer> levelResult = level(root);
            Collections.sort(levelResult);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < levelResult.size() - 1; i++) {
                min = Math.min(min, Math.abs(levelResult.get(i) - levelResult.get(i + 1)));
            }
            return min;
        }

        private List<Integer> level(TreeNode root) {

            List<Integer> ret = new ArrayList<>(10);
            if (root == null) return ret;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                ret.add(poll.val);
                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
            }
            return ret;
        }

        public int getMinimumDifference2(TreeNode root) {
            AtomicReference<Integer> ret = new AtomicReference<>(Integer.MAX_VALUE);
            AtomicReference<TreeNode> pre = new AtomicReference<>();
            midOrder(root, ret, pre);
            return ret.get();
        }

        private void midOrder(TreeNode root, AtomicReference<Integer> ret, AtomicReference<TreeNode> pre) {
            if (root == null) return;
            midOrder(root.left, ret, pre);
            if (pre.get() != null) {

                ret.set(Math.min(ret.get(), root.val - pre.get().val));
            }
            pre.set(root);
            midOrder(root.right, ret, pre);
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
