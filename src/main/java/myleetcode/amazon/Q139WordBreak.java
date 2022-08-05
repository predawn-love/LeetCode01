package myleetcode.amazon;

import java.util.*;

public class Q139WordBreak {
    /**
     * 超时了
     */
    public boolean wordBreak0(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (s.length() > 300) return false;
        if (helper(s, new HashSet<String>(wordDict))) {
            return true;
        }
        return false;
    }

    private boolean helper(String s, HashSet<String> set) {
        if (set.contains(s)) {
            return true;
        }
        for (int j = 1; j <= s.length(); j++) {
            if (set.contains(s.substring(0, j))) {
                if (helper(s.substring(j), set)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * dp
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (s.length() > 300) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();

        // valid[j] 表示，s 的前 0 ~ j - 1 位能否被拆分成字典里面的单词
        // 那么 valid[i] = valid[j] & check(j, i - 1), j < i;
        boolean[] valid = new boolean[n + 1];
        valid[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (valid[j] && set.contains(s.substring(j, i))) {
                    valid[i] = true;
                }
            }
        }
        return valid[n];
    }


    /**
     * dp,此实现不对。待完善
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s.length() == 0) return true;
//        if (s.length() > 300) return false;
//        HashSet<String> set = new HashSet<>(wordDict);
//        int n = s.length();
//
//        // valid[j] 表示，s 的前 0 ~ j - 1 位能否被拆分成字典里面的单词
//        // 那么 valid[i] = valid[j] & check(j, i - 1), j < i;
//        boolean[] valid = new boolean[n + 1];
//        valid[0] = true;
//        for (int i = 0; i <= n; i++) {
//            if (!valid[i]) {
//                continue;
//            }
//            for (int j = 1; j < 22; j++) {
//                if (set.contains(s.substring(i, j))) {
//                    valid[i + j] = true;
//                }
//            }
//        }
//        return valid[n];
//    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aa");
        boolean ab = new Q139WordBreak().wordBreak("aaaaa", list);
        System.out.println(ab);
    }
}
