package myleetcode.amazon;

class Solution1156 {
    public int maxRepOpt1(String text) {
        // 记录 text 字符串内各个字母的出现次数。
        int[] cNum = new int[26];
        char[] txt = text.toCharArray();
        int n = text.length();
        for (char c : txt) {
            cNum[c - 'a']++;
        }
        char currentChar = txt[0];

        // 当前字符构建了多少个。
        int currentNum = 1;
        int maxlen = 0;

        // 整个 for 循环中，i 唯一能改变的地方就是这里的 i++。
        // 所以如果发生了退出循环的事情，一定是 i 自增到头了。
        //
        for (int i = 1; i < n; i++) {
            // 遍历到的字符和 currentChar 相同，currentNum 自增。
            // 进入该语句块结束后会让 i 自增。
            if (txt[i] == currentChar) {
                currentNum++;
            } else {
                // 出现不一致字符。用 next 作为后续访问下标，不改变 i 的值。
                //
                int next = i + 1;
                while (next < n && (txt[next] == currentChar)) {
                    // 第 i+1 个字符与当前字符一致
                    currentNum++;
                    next++;
                }
                if (cNum[currentChar - 'a'] - currentNum > 0) {
                    // 还有与当前字符一样的字符可以用于交换
                    currentNum++;
                }
                maxlen = Math.max(maxlen, currentNum);
                currentChar = txt[i];
                currentNum = 1;
            }
        }

        //  如果还有剩余元素则 currentNum 加 1.(为什么可以确定没有做过交换？)
        //
        if (cNum[currentChar - 'a'] - currentNum > 0) {
            currentNum += 1;
        }
        maxlen = Math.max(maxlen, currentNum);
        return maxlen;
    }
}

public class Q1156SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {

        return 0;
    }
}
