package myleetcode.jian_zhi_offer.day11DoublePointer;

class ListNode {
    int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class DeleteNode {
//    public ListNode deleteNode(ListNode head, int val) {
//        ListNode cur = head;
//        if (head.val == val) {
//            cur = head.next;
//            head.next = null;
//            return cur;
//        }
//        while (cur.next != null && cur.next.val != val) {
//            cur = cur.next;
//        }
//        if (cur.next.val == val) {
//            cur.next = cur.next.next;
//            return head;
//        }
//        return head;
//    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head.next;
        if (head.val == val) {
            cur = head.next;
            head.next = null;
            return cur;
        }
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
