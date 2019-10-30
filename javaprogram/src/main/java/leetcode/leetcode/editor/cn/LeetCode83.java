// 标题:
//      删除排序链表中的重复元素

// 描述:
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

// 思路:

/**
 * 每次比较下一个的值和当前值是否相等, 相等则删掉, 不相等则继续就好了.
 */

// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import javax.xml.soap.Node;

public class LeetCode83{
       public static void main(String[] args) {
            Solution solution = new LeetCode83().new Solution();

           ListNode node1 = new ListNode(1);
           ListNode node2 = new ListNode(1);
           ListNode node3 = new ListNode(2);
           ListNode node4 = new ListNode(3);
           ListNode node5 = new ListNode(3);
           node1.next = node2;
           node2.next = node3;
           node3.next = node4;
           node4.next = node5;

           System.out.println(solution.deleteDuplicates(node1));
           printListNode(node1);
      }

    public static  void printListNode(ListNode n1) {
        while (n1 != null) {
            System.out.print(n1.val);
            n1 = n1.next;
        }
        System.out.println();
    }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null ) return null;
        ListNode root = head;
        int last = head.val;
        while (head.next != null) {
            if (head.next.val == last) {
                head.next = head.next.next;
                continue;
            } else {
                last = head.next.val;
            }
            head = head.next;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}
