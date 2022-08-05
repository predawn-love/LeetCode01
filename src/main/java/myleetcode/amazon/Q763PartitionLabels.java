package myleetcode.amazon;

import java.util.*;

public class Q763PartitionLabels {
    public List<Integer> partitionLabels1(String s) {
        List<Integer> result = new ArrayList<>();
        char[] cs = s.toCharArray();
        Map<Character, Integer> charVsLastIndex = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            charVsLastIndex.put(cs[i], i);
        }
        for (int cur = 0, start = 0, end = 0; cur < cs.length; cur++) {
            end = Math.max(end, charVsLastIndex.get(cs[cur]));
            if (cur == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }


    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] cs = s.toCharArray();
        int[] charVsLastIndex = new int[26];
        for (int i = 0; i < cs.length; i++) {
            charVsLastIndex[cs[i] - 'a'] = i;
        }
        for (int cur = 0, start = 0, end = 0; cur < cs.length; cur++) {
            end = Math.max(end, charVsLastIndex[cs[cur] - 'a']);
            if (cur == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Q763PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}
