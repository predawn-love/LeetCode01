package myleetcode.amazon;

import java.util.*;

class Solution1152 {
    /**
     inner class
     */
    class Log {
        String username;
        int timestamp;
        String website;

        public Log(String _username, int _timestamp, String _website) {
            username = _username;
            timestamp = _timestamp;
            website = _website;
        }
    }

    /**
     inner class
     Comparator for Log
     */
    class LogComparator implements Comparator<Log> {
        @Override
        public int compare(Log log1, Log log2) {
            if( log1.timestamp < log2.timestamp ) {
                return -1;
            }
            else if( log1.timestamp > log2.timestamp ) {
                return 1;
            }
            return 0;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        // Create log
        int len = timestamp.length;
        List<Log> logs = new ArrayList<Log>();
        for( int i = 0; i < len; i++ ) {
            logs.add(new Log(username[i], timestamp[i], website[i]));
        }

        // Use comparator to sort the log
        Collections.sort(logs, new LogComparator());

        // printLogs(logs);

        // HashMap<Username, List<String>> map1
        HashMap<String, List<String>> userVisitMap = new HashMap<String, List<String>>();

        // HashMap<3-Sequence, Integer> map2
        HashMap<List<String>, Integer> patternTimesMap = new HashMap<List<String>, Integer>();

        // memory: O(N)

        // iterate timestamp and build map1
        for( int i = 0; i < logs.size(); i++ ) {
            List<String> visitPattern = userVisitMap.getOrDefault(logs.get(i).username, new ArrayList<String>());
            visitPattern.add(logs.get(i).website);
            userVisitMap.put(logs.get(i).username, visitPattern);
        }

        List<String> mostVisitPattern = new ArrayList<String>();
        int maxFrequency = Integer.MIN_VALUE;
        // iterate userVisitMap and generate all 3-sequence pattern
        // N
        for( String user : userVisitMap.keySet() ) {
            List<String> visitPattern = userVisitMap.get(user);
            // get all 3-sequence pattern of a user
            // < N
            // C(n, 3) = n(n-1)(n-2)
            int size = visitPattern.size();
            // Make sure a certain for one user can only count for once
            HashSet<List<String>> set = new HashSet<List<String>>();
            for( int i = 0; i <= size - 3; i++ ) {
                for( int j = i + 1; j <= size - 2; j++ ) {
                    for( int k = j + 1; k <= size - 1; k++ ) {
                        List<String> threeSequence = new ArrayList<String>();
                        threeSequence.add(visitPattern.get(i));
                        threeSequence.add(visitPattern.get(j));
                        threeSequence.add(visitPattern.get(k));
                        if( set.contains(threeSequence) ) {
                            continue;
                        }
                        set.add(threeSequence);
                        int times = patternTimesMap.getOrDefault(threeSequence, 0);
                        times++;
                        patternTimesMap.put(threeSequence, times);
                        if( times > maxFrequency ) {
                            maxFrequency = times;
                            mostVisitPattern = new ArrayList<String>(threeSequence);
                        }
                        else if( times == maxFrequency ) {
                            // If there is more than one solution,
                            // return the lexicographically smallest such 3-sequence.
                            mostVisitPattern = new ArrayList<String>(getAlphabetSequence(mostVisitPattern, threeSequence));
                        }
                    }
                }
            }

        }
        return mostVisitPattern;
    }

    /**
     return the lexicographically smallest such 3-sequence.
     */
    private List<String> getAlphabetSequence(List<String> mostVisitPattern, List<String> threeSequence) {
        for( int i = 0; i < 3; i++ ) {
            // Compare every website
            int index = 0;
            String word1 = mostVisitPattern.get(i);
            String word2 = threeSequence.get(i);
            while( index < word1.length() && index < word2.length() ) {
                if( word1.charAt(index) < word2.charAt(index) ) {
                    return mostVisitPattern;
                }
                else if( word1.charAt(index) > word2.charAt(index) ) {
                    return threeSequence;
                }

                // word1.charAt(index) == word2.charAt(index)
                index++;
            }
            if( index == word1.length() && index < word2.length() ) {
                return mostVisitPattern;
            }
            if( index == word2.length() && index < word1.length() ) {
                return threeSequence;
            }
        }
        return mostVisitPattern;
    }

    /**
     print all logs
     */
    private void printLogs( List<Log> logs ) {
        for( int i = 0; i < logs.size(); i++ ) {
            Log log = logs.get(i);
            System.out.println(log.username +" " + log.timestamp + " " + log.website);
        }
    }

}
public class Q1152AnalyzeUserWebsiteVisitPattern {
    /**
     inner class
     */
    class Log {
        String username;
        int timestamp;
        String website;

        public Log(String _username, int _timestamp, String _website) {
            username = _username;
            timestamp = _timestamp;
            website = _website;
        }
    }

    /**
     * 题目要求：返回一个长度为3的网站列表，该列表的含义是存在用户从左往右先后访问这些网站，并且用户数最多。
     * 存在相同用户数的这种列表时，返回列表字典序最小的。 (这种3元列表题目里称为 pattern)
     */
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // 创建日志
        int len = timestamp.length;
        List<Log> logs = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            logs.add(new Log(username[i], timestamp[i], website[i]));
        }

        // 按时间排序
        Collections.sort(logs, (a, b) -> a.timestamp - b.timestamp);

        // HashMap<Username, List<String>> map1, 这里记录了每个用户访问过的全部网站名
        HashMap<String, List<String>> userVisitMap = new HashMap<>();

        // HashMap<3-Sequence, Integer> map2
        HashMap<List<String>, Integer> patternTimesMap = new HashMap<>();


        // 遍历 timestamp 构建 map1
        for (int i = 0; i < len; i++) {
            List<String> visitPattern = userVisitMap.getOrDefault(logs.get(i).username, new ArrayList<>());
            visitPattern.add(logs.get(i).website);
            userVisitMap.put(logs.get(i).username, visitPattern);
        }

        List<String> mostVisitPattern = new ArrayList<>();
        int maxFrequency = Integer.MIN_VALUE;

        // 遍历 userVisitMap 生成全部有可能的 3-sequence pattern
        for (List<String> visitPattern : userVisitMap.values()) {
            int size = visitPattern.size();
            // 确保每个 user 只会计数一次
            HashSet<List<String>> set = new HashSet<>();
            for (int i = 0; i < size - 2; i++) {
                for (int j = i + 1; j < size - 1; j++) {
                    for (int k = j + 1; k < size; k++) {
                        List<String> threeSequence = new ArrayList<>();
                        threeSequence.add(visitPattern.get(i));
                        threeSequence.add(visitPattern.get(j));
                        threeSequence.add(visitPattern.get(k));
                        if (set.contains(threeSequence)) {
                            continue;
                        }
                        set.add(threeSequence);
                        int times = patternTimesMap.getOrDefault(threeSequence, 0);
                        times++;
                        patternTimesMap.put(threeSequence, times);
                        if (times > maxFrequency) {
                            maxFrequency = times;

                            // 防止 mostVisitPattern 被更改
                            mostVisitPattern = new ArrayList<>(threeSequence);
                        } else if (times == maxFrequency) {
                            // 当有多个可行解决方案时（不同用户总数相同的3-sequence）
                            // 返回字典序最小的
                            mostVisitPattern = new ArrayList<>(getAlphabetSequence(mostVisitPattern, threeSequence));
                        }
                    }
                }
            }
        }
        return mostVisitPattern;
    }

    /**
     return the lexicographically smallest such 3-sequence.
     */
    private List<String> getAlphabetSequence(List<String> mostVisitPattern, List<String> threeSequence) {
        for (int i = 0; i < 3; i++) {
            // Compare every website
            int index = 0;
            String word1 = mostVisitPattern.get(i);
            String word2 = threeSequence.get(i);
            while (index < word1.length() && index < word2.length()) {
                int compareRes = word1.compareTo(word2);
                if (compareRes < 0) {
                    return mostVisitPattern;
                } else if (compareRes > 0) {
                    return threeSequence;
                } else {
                    index++;
                }
            }
        }
        return mostVisitPattern;
    }
}
