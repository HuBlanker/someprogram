// 标题:
//      移除链表元素

// 描述:
//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

// 思路:

/**
 * Created by huyanshi on 191029.
 * 按照普通的思路来即可.
 *
 * 为了处理第一个节点, 我们给前面加一个自定义的root节点, 之后不断检查next, 如果和 给定值相等, 让next=next.next即可.
 *
 * 注意, 每次只能走一步, 如果 在next = next.next之后又走了 root=root.next, 那么就是两步, 会跳过一些节点的.
 *
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import leetcode.util.LeetCodeUtil;

public class LeetCode203 {
    public static void main(String[] args) {
        Solution solution = new LeetCode203().new Solution();
        ListNode[] a = new ListNode[10];
        a[0] = new ListNode(1);
        a[1] = new ListNode(2);
        a[2] = new ListNode(6);
        a[3] = new ListNode(3);
        a[4] = new ListNode(4);
        a[5] = new ListNode(5);
        a[6] = new ListNode(6);

        a[0].next = a[1];
        a[1].next = a[2];
        a[2].next = a[3];
        a[3].next = a[4];
        a[4].next = a[5];
        a[5].next = a[6];
        System.out.println(solution.removeElements(a[0], 6));
        LeetCodeUtil.printListNode(solution.removeElements(a[0], 6));
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode root = new ListNode(0);
            root.next = head;
            ListNode tmp = root;
            while (root.next != null) {
                if (root.next.val == val) {
                    root.next = root.next.next;
                } else {
                    root = root.next;
                }
            }
            return tmp.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
