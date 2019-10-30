package leetcode.other;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by pfliu on 2019/10/15.
 */
public class FarestNodeInBinaryTree {
    public static void main(String[] args) {

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

        AtomicReference<Integer> ret = new AtomicReference<>(0);
        System.out.println(new FarestNodeInBinaryTree().far(ns[0], ret));
        System.out.println(ret.get());
    }

    public int far(TreeNode node, AtomicReference<Integer> result) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.left != null) left = far(node.left, result) + 1;
        if (node.right != null) right = far(node.right, result) + 1;
        int tmp = Math.max(result.get(), left + right);
        result.set(tmp);
        return Math.max(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

