package myleetcode.string;

import java.util.*;

public class Q433MinimumGeneticMutation {
    /**
     * 常规 BFS
     */
    public static final char[] GENES0 = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation0(String start, String end, String[] bank) {
        Map<String, Integer> geneVsIndex = new HashMap<>();
        int index = 0;
        for (String s : bank) {
            geneVsIndex.put(s, index++);
        }
        int n = bank.length;
        boolean[] visited = new boolean[n];
        int len = start.length();
        int times = 0;
        Deque<String> deque = new ArrayDeque<>();
        deque.add(start);

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String s = deque.pollFirst();
                char[] cs = s.toCharArray();

                // 从头至尾枚举每一位。
                for (int i = 0; i < len; i++) {
                    char curChar = cs[i];

                    // 将第 i 位枚举 3 种变化
                    for (char gene : GENES0) {
                        if (curChar == gene) {
                            continue;
                        }
                        cs[i] = gene;
                        String nextGene = new String(cs);
                        if (geneVsIndex.containsKey(nextGene) && !visited[geneVsIndex.get(nextGene)]) {
                            visited[geneVsIndex.get(nextGene)] = true;
                            deque.add(nextGene);
                            if (nextGene.equals(end)) {
                                return ++times;
                            }
                        }
                    }

                    // 复原第 i 位。
                    cs[i] = curChar;
                }
            }
            times++;
        }
        return -1;
    }


    /**
     * 双向 BFS
     */
    public static final char[] GENES = new char[]{'A', 'C', 'G', 'T'};
    private Set<String> geneSet;
    public static final int GENE_LEN = 8;

    public int minMutation(String start, String end, String[] bank) {
        Map<String, Integer> geneVsStepFromStart = new HashMap<>();
        Map<String, Integer> geneVsStepFromEnd = new HashMap<>();
        geneVsStepFromStart.put(start, 0);
        geneVsStepFromEnd.put(end, 0);

        geneSet = new HashSet<>();
        for (String s : bank) {
            geneSet.add(s);
        }

        Deque<String> dequeFromStart = new ArrayDeque<>();
        Deque<String> dequeFromEnd = new ArrayDeque<>();
        dequeFromStart.add(start);
        dequeFromEnd.add(end);
        int step = -1;
        while (!dequeFromStart.isEmpty() && !dequeFromEnd.isEmpty()) {
            if (dequeFromStart.size() > dequeFromEnd.size()) {
                step = update(dequeFromEnd, geneVsStepFromEnd, geneVsStepFromStart);
            } else {
                step = update(dequeFromStart, geneVsStepFromStart, geneVsStepFromEnd);
            }
            if (step != -1) {
                return step;
            }
        }
        return step;
    }

    private int update(Deque<String> deque, Map<String, Integer> geneVsStep, Map<String, Integer> geneVsStepAnother) {
        int size = deque.size();
        while (size-- > 0) {
            String s = deque.pollFirst();
            char[] cs = s.toCharArray();
            int nowStep = geneVsStep.get(s);

            // 从头至尾枚举每一位。
            for (int i = 0; i < GENE_LEN; i++) {
                char curChar = cs[i];

                // 将第 i 位枚举 3 种变化
                for (char gene : GENES) {
                    if (curChar == gene) {
                        continue;
                    }
                    cs[i] = gene;
                    String nextGene = new String(cs);
                    if (!geneSet.contains(nextGene) || geneVsStep.containsKey(nextGene)) {
                        continue;
                    }
                    if (geneVsStepAnother.containsKey(nextGene)) {
                        return nowStep + geneVsStepAnother.get(nextGene) + 1;
                    }
                    geneVsStep.put(nextGene, nowStep + 1);
                    deque.add(nextGene);
                }

                // 复原第 i 位。
                cs[i] = curChar;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Q433MinimumGeneticMutation().minMutation("A", "B", new String[]{"B"});
        System.out.println(i);
    }
}
