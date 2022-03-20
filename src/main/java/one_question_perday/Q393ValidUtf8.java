package one_question_perday;

public class Q393ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n;) {
            int curNum = data[i];
            int j = 7;
            while (j >= 0 && (((curNum >> j) & 1) == 1)) {
                j--;
            }
            int cnt = 7 - j;
            if (cnt == 1 || cnt > 4) {
                return false;
            }
            if (i + cnt - 1 >= n) {
                return false;
            }
            for (int k = i + 1; k <= i + cnt - 1; k++) {
                int nextNum = data[k];
                if ((nextNum >> 7 & 1) == 1 && (nextNum >> 6 & 1) == 0) {
                    continue;
                }
                return false;
            }
            if (cnt == 0) {
                i++;
            } else {
                i += cnt;
            }
        }
        return true;
    }







































}