package microsoft;

public class Q21MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        while (cur1 != null) {
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while (cur2 != null) {
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
