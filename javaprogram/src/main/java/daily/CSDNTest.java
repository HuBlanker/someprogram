package daily;


/**
 * Created by pfliu on 2019/12/06.
 */
public class CSDNTest {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //由于不知道两个链表哪个头结点大,所以自定义一个头结点
        ListNode dummy = new ListNode(-1), cur = dummy;
        //当两个链表都不为空
        while (l1 != null && l2 != null) {
            //将两个链表中较小的当前节点链接在结果链表上,该链表后移一位
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            //结果链表也后移一位
            cur = cur.next;
        }
        //当其中一个为空时,将另一个链表剩余所有值链接在结果链表上
        cur.next = (l1 != null) ? l1 : l2;
        //返回自定义的头结点的下一个节点
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String [] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(7);
        n4.next = n5;
        n5.next = n6;

        ListNode listNode = mergeTwoLists(n1, n4);

        System.out.println("=======");

    }
}
