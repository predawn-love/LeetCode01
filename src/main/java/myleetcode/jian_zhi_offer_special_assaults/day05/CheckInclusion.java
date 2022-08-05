package myleetcode.jian_zhi_offer_special_assaults.day05;

public class CheckInclusion {
    /**
     * 自己写的双指针
     */
//    public boolean checkInclusion(String s1, String s2) {
//        if (s1 == null || s2 == null || s2.length() < s1.length()) {
//            return false;
//        }
//        int differentNum = s1.length();
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        int[] wordInts1 = new int[26];
//        int[] wordInts2 = new int[26];
//        for (char c : chars1) {
//            wordInts1[c - 'a']++;
//        }
//        int index;
//        for (int i = 0; i < s1.length(); i++) {
//            index = chars2[i] - 'a';
//            if (wordInts2[index] < wordInts1[index]) {
//                differentNum--;
//                if (differentNum == 0) {
//                    return true;
//                }
//            }
//            wordInts2[index]++;
//        }
//        for (int i = s1.length(), j = 0; i < s2.length(); i++, j++) {
//            index = chars2[i] - 'a';
//            if (wordInts2[index] < wordInts1[index]) {
//                differentNum--;
//            }
//            wordInts2[index]++;
//            int indexToRemove = chars2[j] - 'a';
//            if (wordInts2[indexToRemove] <= wordInts1[indexToRemove]) {
//                differentNum++;
//            }
//            wordInts2[indexToRemove]--;
//            if (differentNum == 0) {
//                return true;
//            }
//        }
//        return false;
//    }


    /**
     * 官解双指针
     */
//    public boolean checkInclusion(String s1, String s2) {
//        int n = s1.length(), m = s2.length();
//        if (n > m) {
//            return false;
//        }
//        int[] cnt = new int[26];
//        for (int i = 0; i < n; ++i) {
//            --cnt[s1.charAt(i) - 'a'];
//        }
//        int left = 0;
//        for (int right = 0; right < m; ++right) {
//            int x = s2.charAt(right) - 'a';
//            ++cnt[x];
//            while (cnt[x] > 0) {
//                --cnt[s2.charAt(left) - 'a'];
//                ++left;
//            }
//            if (right - left + 1 == n) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int n = s1.length(), m = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[chars1[i] - 'a'];
        }
        for (int right = 0, left = 0; right < m; ++right) {
            int x = chars2[right] - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[chars2[left] - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
