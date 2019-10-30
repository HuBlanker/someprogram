// 标题:
// 合并两个有序链表

// 描述:
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

// 思路:

/**
 * 首先需要一个根节点, 不然处理谁是第一个比较麻烦.
 * 然后两个链表各自一个指针,谁小将root的下一个指向谁,且该指针向后移动即可.
 * 最后返回root.next即可.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import javax.sound.midi.Soundbank;

public class LeetCode21 {
    public static void main(String[] args) {
        Solution solution = new LeetCode21().new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        System.out.println(solution.mergeTwoLists(node1, node4).val);
    }


// My Code End


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            ListNode cursor = root;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    root.next = l2;
                    l2 = l2.next;
                } else if (l2 == null) {
                    root.next = l1;
                    l1 = l1.next;
                } else {
                    if (l1.val >= l2.val) {
                        root.next = l2;
                        l2 = l2.next;
                    } else {
                        root.next = l1;
                        l1 = l1.next;
                    }
                }
                root = root.next;
            }
            return cursor.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
