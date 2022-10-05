package myleetcode.amazon;

import java.util.*;

public class Q56MergeIntervals {
    public int[][] merge1(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] ints : intervals) {
            int curKey = ints[0];
            int curValue = ints[1];
            Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(curKey);
            Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(curKey);

            boolean hasMergedFloor = false;
            if (floorEntry != null) {
                int floorEntryKey = floorEntry.getKey();
                int floorEntryValue = floorEntry.getValue();
                if (curValue <= floorEntryValue) {
                    // 包含于现有的左区间
                    continue;
                } else {
                    if (curKey <= floorEntryValue) {
                        treeMap.put(floorEntryKey, curValue);
                        hasMergedFloor = true;
                    }
                }
            }

            boolean hasMergedCeiling = false;
            if (ceilingEntry != null) {
                int ceilingKey = ceilingEntry.getKey();
                int ceilingValue = ceilingEntry.getValue();
                if (ceilingKey <= curValue) {
                    // 当前区间和现有的右区间有交集
                    if (hasMergedFloor) {
                        treeMap.put(floorEntry.getKey(), Math.max(curValue, ceilingValue));
                    } else {
                        treeMap.put(curKey, Math.max(curValue, ceilingValue));
                        treeMap.remove(ceilingKey);
                    }
                    hasMergedCeiling = true;
                }
            }

            if (!hasMergedCeiling && !hasMergedFloor) {
                treeMap.put(curKey, curValue);
            }
        }

        int[][] res = new int[treeMap.size()][2];
        int index = 0;
        Set<Map.Entry<Integer, Integer>> entries = treeMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInts = res.peekLast();
            int[] curInterval = intervals[i];
            int curLeft = curInterval[0];
            int curRight = curInterval[1];
            if (curLeft <= lastInts[1]) {
                res.pollLast();
                res.add(new int[]{lastInts[0], Math.max(curRight, lastInts[1])});
            } else {
                res.add(curInterval);
            }
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        new Q56MergeIntervals().merge(new int[][]{{1,4},{0,4}});
    }
}
