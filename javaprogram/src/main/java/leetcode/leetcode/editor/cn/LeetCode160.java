// 标题:
//      相交链表

// 描述:
//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表

// 思路:

/**
 * Created by huyanshi on 191021.
 * 1. hash表法, 先遍历A链表, 把所有节点加入到hashset中. 遍历B链表, 如果某个节点在set中, 那就是交点.
 *
 * 2. 指针追逐法:  两个指针,一个指向a,一个指向b. 开始遍历, 当a到达结尾时, 指向b的头结点, b反之. 当两个指针相遇的时候, 说明是链表的交点.
 *
 * 3. 长度差法: 先求出两个链表的长度差, 然后让长的先走 a-b 步, 然后两个链表同时开始遍历. 相遇则是交点.
 *
 * 原因: 从头开始遍历的两个指针无法相遇的原因就是长度不一样, 虽然他们有相同的后缀, 但是我们不知道 长度差.
 *所以在第三个方法中, 先将长度差求出来, 再遍历.
 * 或者像第二种方法中那样, 让两个指针都走一遍 A+B, 这样子就可以弥补长度的差值, 同时到达交点.
 *
 */

// ===============思路end=============


package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.*;

public class LeetCode160 {
    public static void main(String[] args) {
        Solution solution = new LeetCode160().new Solution();
        ListNode[] a = new ListNode[10];
        a[0] = new ListNode(4);
        a[0] = new ListNode(1);
        a[0] = new ListNode(8);
        a[0] = new ListNode(4);
        a[0] = new ListNode(5);

        a[0] = new ListNode(4);
        a[0] = new ListNode(4);
        a[0] = new ListNode(4);
        a[0] = new ListNode(4);
        a[0] = new ListNode(4);
    }


// My Code End


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            Set<Integer> h = new HashSet<>();
            while (headA != null) {
                h.add(headA.val);
                headA = headA.next;
            }
            while (headB != null) {
                if (h.contains(headB.val)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode a = headA;
            ListNode b = headB;
            while (!a.equals(b)) {
                a = a.next == null ? b : a.next;
                b = b.next == null ? a : b.next;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
