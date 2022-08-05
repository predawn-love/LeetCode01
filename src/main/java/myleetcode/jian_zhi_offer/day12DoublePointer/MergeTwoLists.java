package myleetcode.jian_zhi_offer.day12DoublePointer;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                pre.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            pre = pre.next;
        }
        while (list1 != null) {
            pre.next = new ListNode(list1.val);
            list1 = list1.next;
            pre = pre.next;
        }
        while (list2 != null) {
            pre.next = new ListNode(list2.val);
            list2 = list2.next;
            pre = pre.next;
        }
        pre = dummy.next;
        dummy.next = null;
        return pre;
    }
}
