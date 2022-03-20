package two_pointer;

public class Q1156MaxRepOpt1 {
    public int maxRepOpt1(String text) {
        int[] cnum = new int[26];
        char[] txt = text.toCharArray();
        int len = text.length();

        // 统计词频到 cnum 数组里
        for (char c : txt) {
            cnum[c - 'a']++;
        }
        char currentchar = txt[0];

        int currentnum = 1;
        int maxlen = 0;
        for (int i = 1; i < len; i++) {
            if (txt[i] == currentchar) {
                currentnum++;
            } else {
                //出现不一致字符
                int next = i + 1;

                //第 i + 1 个字符与当前字符一致
                while (next < len && (txt[next] == currentchar)) {
                    currentnum++;
                    next++;
                }

                //还有与当前字符一样的字符可以用于交换
                if (cnum[currentchar - 'a'] - currentnum > 0) {
                    currentnum++;
                }
                maxlen = Math.max(maxlen, currentnum);
                currentchar = txt[i];
                currentnum = 1;
            }
        }
        if (cnum[currentchar - 'a'] - currentnum > 0) {
            currentnum += 1;
        }
        maxlen = Math.max(maxlen, currentnum);
        // if (currentnum)
        return maxlen;
    }
}
