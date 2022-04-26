package myleetcode.jian_zhi_offer.day17_sort;

import java.util.PriorityQueue;

public class MedianFinder {
    /**
     * 解法有误，记得debug
     */
    // 这个里面存小的一半，用大根堆。 保证 minHeap.size() <= maxHeap.size();
    private PriorityQueue<Integer> minHeap;
    // 这个里面存大的一半，用小根堆。
    private PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>((x, y) -> y - x);
        maxHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int m = minHeap.size();
        int n = maxHeap.size();
        if (m == n) {
            // 目标是往 maxHeap 里插入，所以先往 minHeap 插入，然后把 minHeap 的顶端元素插入 maxHeap
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        int m = minHeap.size();
        int n = maxHeap.size();
        if (m == n) {
            return (double) minHeap.peek() + (double) maxHeap.peek() / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

}



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */