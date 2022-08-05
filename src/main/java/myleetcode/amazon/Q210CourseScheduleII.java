package myleetcode.amazon;

import java.util.*;

class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // [1,0] 0 -> 1
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        // 将入度为 0 的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // 当前结果集列表里的元素个数，正好可以作为下标
        int count = 0;

        while (!queue.isEmpty()) {
            // 当前入度为 0 的结点
            Integer head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

}
public class Q210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        // 初始化邻接表
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // [1, 0] 0->1
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        // 入度为零的入队
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            // 当前入度为 0 的节点
            Integer head = queue.poll();
            res[count++] = head;

            // 以该节点出发，可以到达的后续节点的集合
            HashSet<Integer> adjElement = adj[head];
            for (int nextCourse : adjElement) {
                // 后续节点入度减1，若为 0 则入队
                if (--inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }
}
