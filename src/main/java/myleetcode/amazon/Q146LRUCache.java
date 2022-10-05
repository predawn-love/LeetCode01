package myleetcode.amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//class LRUCache extends LinkedHashMap<Integer, Integer> {
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75f, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}

class LRUCache {
    class Node {
        int k, v;
        Node l, r;

        Node(int _k, int _v) {
            k = _k;
            v = _v;
        }
    }

    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        // 初始化
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        // 建链
        head.r = tail;
        tail.l = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        refresh(node);
        return node.v;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.v = value;
        } else {
            if (map.size() == capacity) {
                Node del = tail.l;
                map.remove(del.k);
                delete(del);
            }
            node = new Node(key, value);
            map.put(key, node);
        }

        // 如果该 Node 原先不在缓存里，refresh 还负责插入缓存底层中的双向链表
        // 由于 refresh 调用了 delete，所以针对当前场景 delete 要先判空
        refresh(node);
    }

    // refresh 操作分两步：
    // 1.先将当前节点从双向链表中删除（如果该节点本身存在于双向链表中）
    // 2.将当前节点添加到双向链表头部
    private void refresh(Node node) {
        // step1:
        delete(node);

        // step2:
        node.r = head.r;
        node.l = head;
        head.r.l = node;
        head.r = node;
    }

    // delete 操作：将当前节点从双向链表中删除
    // 由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.l 不为空
    // 则代表了 node 本身存在于双向链表（不是新节点）
    private void delete(Node node) {
        if (node.l == null) {
            return;
        }
        Node leftNode = node.l;
        leftNode.r = node.r;
        node.r.l = leftNode;
    }
}
public class Q146LRUCache {
}
