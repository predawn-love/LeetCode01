package myleetcode.amazon;

class Q92 {
    /**
     * 解法1：大雪菜的思路： ....,a,m,......,n,c,...
     * b指针指向m处，d指针指向n处。我们要翻转[m,n]区间内的节点.即[b,d]
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (n == m) {
//            return head;
//        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode a = dummy;
        ListNode d;
        for (int i = 0; i < m - 1; i++) {
            a = a.next;
        }
        d = a;
        for (int j = m; j <= n; j++) {
            d = d.next;
        }
        ListNode b = a.next;
        ListNode c = d.next;

        // 接下来我们要做的是翻转 [b, d]之间的节点
        for (ListNode p = b, q = b.next; q != c;) {
            ListNode o = q.next;
            q.next = p;
            p = q;
            q = o;
        }

        // m指向c，a指向n
        a.next.next = c;
        a.next = d;
        return dummy.next;
    }
}
public class Q92ReverseLinkedListII {
    /**
     * 自己写的
     */
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode dummy = new ListNode(-1, head);
//        ListNode preLeft = dummy;
//        while (preLeft != null && left-- != 1) {
//            preLeft = preLeft.next;
//            right--;
//        }
//        // 当前指针 preLeft 在 left 的前一位
//        ListNode pre = preLeft;
//        ListNode cur = preLeft.next;
//
//        // 要让 cur 到 right 的后一位，pre 指向 right
//        while (right-- != 0) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        preLeft.next.next = cur;
//        preLeft.next = pre;
//        return dummy.next;
//    }

    /**
     * 解法1：大雪菜的思路： ....,a,m,......,n,c,...
     * b指针指向m处，d指针指向n处。我们要翻转[m,n]区间内的节点.即[b,d]
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode a = dummy;
        ListNode d;
        for (int i = 1; i < m; i++) {
            a = a.next;
        }
        d = a;
        for (int j = m; j <= n; j++) {
            d = d.next;
        }
        ListNode b = a.next;
        ListNode c = d.next;

        // 接下来我们要做的是翻转 [b, d] 之间的节点
        for (ListNode pre = b, cur = b.next; cur != c;) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // m指向c，a指向n
        a.next.next = c;
        a.next = d;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode = new Q92ReverseLinkedListII().reverseBetween(listNode1, 2, 4);

    }
}
