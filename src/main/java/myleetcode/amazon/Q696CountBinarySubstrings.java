package myleetcode.amazon;

import java.util.ArrayList;
import java.util.List;

class Q696 {
    public int countBinarySubstrings0(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }

    public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

}
public class Q696CountBinarySubstrings {
//    public int countBinarySubstrings(String s) {
//        char[] cs = s.toCharArray();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0 ; i < cs.length; i++) {
//            char cur = cs[i];
//            int count = 0;
//            while (i < cs.length && cur == cs[i]) {
//                count++;
//                i++;
//            }
//            arrayList.add(count);
//        }
//        int ans = 0;
//        for (int i = 0; i < arrayList.size() - 1; i++) {
//            ans += Math.min(arrayList.get(i), arrayList.get(i + 1));
//        }
//        return ans;
//    }

    public int countBinarySubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int last = 0;
        int ans = 0;
        for (int i = 0; i < n;) {
            char cur = cs[i];
            int count = 0;
            while (i < n && cur == cs[i]) {
                count++;
                i++;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new Q696CountBinarySubstrings().countBinarySubstrings("001100011101");
        System.out.println(i);
    }
}
