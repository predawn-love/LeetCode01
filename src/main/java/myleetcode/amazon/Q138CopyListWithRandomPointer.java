package myleetcode.amazon;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution138 {
    public Node copyRandomList0(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node tail = dummy, tmp = head;
        while (tmp != null) {
            Node node = new Node(tmp.val);
            map.put(tmp, node);
            tail.next = node;
            tail = tail.next;
            tmp = tmp.next;
        }
        tail = dummy.next;
        while (head != null) {
            if (head.random != null) {
                tail.random = map.get(head.random);
            }
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        Node ans = head.next;
        while (head != null) {
            Node tmp = head.next;
            if (head.next != null) head.next = head.next.next;
            head = tmp;
        }
        return ans;
    }

}

public class Q138CopyListWithRandomPointer {

    /**
     * 哈希表记录旧节点和新节点的关系，先深拷贝出一个单向链表，
     * 然后根据 map 同步遍历旧链表和新链表维护出 random
     */
    public Node copyRandomList0(Node head) {
        Map<Node, Node> oldVsNew = new HashMap<>();
        Node dummy = new Node(-1);
        Node tail = dummy, oldCurPtr = head;
        while (oldCurPtr != null) {
            Node node = new Node(oldCurPtr.val);
            oldVsNew.put(oldCurPtr, node);
            tail.next = node;
            tail = tail.next;
            oldCurPtr = oldCurPtr.next;
        }
        tail = dummy.next;
        oldCurPtr = head;
        while (oldCurPtr != null) {
            if (oldCurPtr.random != null) {
                tail.random = oldVsNew.get(oldCurPtr.random);
            }
            tail = tail.next;
            oldCurPtr = oldCurPtr.next;
        }
        return dummy.next;
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;

        // 在原链表的每一个节点后面插入一个新节点
        while (head != null) {
            Node temp = new Node(head.val);
            temp.next = head.next;
            head.next = temp;
            head = temp.next;
        }

        // 维护 random
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = dummy.next;
        Node ans = head.next;
        Node curPtr = ans;
        while (head != null) {
            head.next = curPtr.next;
            head = head.next;
            if (head != null) {
                curPtr.next = head.next;
            }
            curPtr = curPtr.next;
        }
        head = dummy.next;
        return ans;
    }
}
















