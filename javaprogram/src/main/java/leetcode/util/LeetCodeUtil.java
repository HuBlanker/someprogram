package leetcode.util;

import leetcode.leetcode.editor.cn.LeetCode203;

/**
 * Created by pfliu on 2019/10/29.
 */
public class LeetCodeUtil {

    public static void printListNode(LeetCode203.ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }
}
