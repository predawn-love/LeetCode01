package myleetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1710MaximumUnitsOnATruck {
//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//        for (int[] ints : boxTypes) {
//            pq.offer(ints);
//        }
//        int ans = 0;
//        while (!pq.isEmpty()) {
//            int[] poll = pq.poll();
//            while (poll[0] > 0 && truckSize > 0) {
//                ans += poll[1];
//                truckSize--;
//                poll[0]--;
//            }
//        }
//        return ans;
//    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        // 贪心,先让能装多的箱子上车
        int ans = 0;
        for (int[] box : boxTypes) {
            if (box[0] < truckSize) {
                ans += box[0] * box[1];
                truckSize -= box[0];
            } else {
                ans += truckSize * box[1];
                return ans;
            }
        }
        return ans;
    }
}
