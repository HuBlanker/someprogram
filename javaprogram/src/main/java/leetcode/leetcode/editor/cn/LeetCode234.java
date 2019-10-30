// 标题:
//      回文链表

// 描述:
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

// 思路:

/**
 * Created by huyanshi on 191022.
 *
 *  核心思路就是要: 翻转一半的链表,然后 两个半段链表对比.
 *
 *  翻转一般的链表可以先统计一遍长度, 也可以使用快慢指针(一个一格,一个两格).
 *
 *  注意当链表长度为奇数或者偶数的时候, 回文是不一样的即可.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode234 {
    public static void main(String[] args) {
        Solution solution = new LeetCode234().new Solution();

        ListNode[] a = new ListNode[10];
        a[0] = new ListNode(1);
        a[1] = new ListNode(2);
//        a[2] = new ListNode(2);
//        a[3] = new ListNode(1);

        a[0].next = a[1];
//        a[1].next = a[2];
//        a[2].next = a[3];

        System.out.println(solution.isPalindrome(a[0]));
        System.out.println(solution.isPalindrome(null));
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            int length = 0;
            ListNode tmp = head;
            while (tmp != null) {
                length++;
                tmp = tmp.next;
            }
            ListNode pre = null;
            int i = 0;
            ListNode head2 = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                i++;
                if (i >= (length >> 1)) {
                    if ((length & 1) == 1) {
                        head2 = head == null ? pre : head.next;
                    } else {
                        head2 = head;
                    }
                    head = pre;
                    break;
                }
            }
            while (head != null && head2 != null) {
                if (head.val == head2.val) {
                    head = head.next;
                    head2 = head2.next;
                } else {
                    return false;
                }
            }
            return head == null && head2 == null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
