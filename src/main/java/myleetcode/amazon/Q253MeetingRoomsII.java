package myleetcode.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
           return a[1] - b[1];
        });

        int ans = 0;
        for (int[] ints : intervals) {
            while (!queue.isEmpty() && ints[0] >= queue.peek()[1]) {
                queue.poll();
            }
            queue.offer(ints);
            ans = Math.max(queue.size(), ans);
        }
        return ans;
    }
}
