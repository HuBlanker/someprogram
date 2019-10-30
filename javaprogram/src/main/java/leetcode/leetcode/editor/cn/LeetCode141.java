// 标题:
//      环形链表

// 描述:
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

// 思路:

/**
 * Created by huyanshi on 191011
 *
 * 环形链表问题,
 *
 * 解法1: 添加访问标志, 每次路过一个点, 将他添加到已访问的集合里, 如果某次访问的点已经访问过就是有环. 到了结尾就是没有环. 空间n,时间n.
 *
 * 解法2: 快慢指针, 一个环形跑道上, 一个快一个慢迟早会相遇, 所以 慢指针一次走1步, 快指针走2步. 如果走到结尾则无环. 中间某次快慢相遇则有环.
 *
 * 解法3: 翻转链表法,每次走完一步之后, 翻转当前节点, 如果最后又走了回来, 走到head了, 那说明是有环的.
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

public class LeetCode141 {
    public static void main(String[] args) {
        Solution solution = new LeetCode141().new Solution();
    }


// My Code End


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
