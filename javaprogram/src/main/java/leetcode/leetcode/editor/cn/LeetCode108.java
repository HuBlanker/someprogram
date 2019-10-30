// 标题:
//      将有序数组转换为二叉搜索树

// 描述:
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

// 思路:

/**
 * 递归, 构建一棵树等于选定根节点之后分别构建左右子树.
 *
 * 根节点是数组中间的节点,选择中间的节点时, 使用 l + ( r - l) /2 可以避免溢出.
 *
 * 之后用根节点左边的数据构建左子树, 右边的节点构建右子树.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode108 {
    public static void main(String[] args) {
        Solution solution = new LeetCode108().new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).val);
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return nums == null ? null : build(nums, 0, nums.length - 1);

        }

        private TreeNode build(int[] nums, int i, int j) {
            if (i > j) return null;
            int mid = i + ((j - i) >> 1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, i, mid - 1);
            root.right = build(nums, mid + 1, j);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
