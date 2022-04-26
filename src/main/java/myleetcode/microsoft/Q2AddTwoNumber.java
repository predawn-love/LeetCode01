package myleetcode.microsoft;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Q2AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 记录进位值
        int carry = 0;
        int curSum = 0;

        // dummy.next 为要返回的链表的头节点
        ListNode dummy = new ListNode(-1);

        // 辅助指针，含义为：下一节点为当前计算位。
        ListNode pre = dummy;

        // 辅助指针，防止函数结束后对 l1 和 l2造成变动
        ListNode curL1 = l1;
        ListNode curL2 = l2;

        // 循环逐位相加
        while (curL1 != null && curL2 != null) {
            curSum = curL1.val + curL2.val + carry; // 两数当前位相加，再加上进位值
            pre.next = new ListNode(curSum % 10);   //  获取并拼接当前计算的节点
            carry = curSum / 10;    // 重置进位值
            pre = pre.next; // 维护 pre 指针
            curL1 = curL1.next; // 维护 curL1 和 curL2
            curL2 = curL2.next;
        }

        // 善后处理（l1 和 l2 如果不等长，即位数不同）
        while (curL1 != null) {
            curSum = curL1.val + carry; // 两数当前位相加，再加上进位值
            pre.next = new ListNode(curSum % 10);   //  获取并拼接当前计算的节点
            carry = curSum / 10;    // 重置进位值
            pre = pre.next; // 维护 pre 指针
            curL1 = curL1.next; // 维护 curL1
        }
        while (curL2 != null) {
            curSum = curL2.val + carry; // 两数当前位相加，再加上进位值
            pre.next = new ListNode(curSum % 10);   //  获取并拼接当前计算的节点
            carry = curSum / 10;    // 重置进位值
            pre = pre.next; // 维护 pre 指针
            curL2 = curL2.next; // 维护 curL2
        }

        if (carry != 0) {
            pre.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
