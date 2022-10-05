package myleetcode.string;

public class Q38CountAndSay {
    public String countAndSay(int n) {
        char[] s = {1};
        for (int i = 0; i < n - 1; i++) {
            StringBuffer ns = new StringBuffer("");
            for (int j = 0; j < s.length; j++) {
                int k = j;
                while (k < s.length && s[k] == s[j]) {
                    k++;
                }
                ns.append((k - j) + s[j]);
                j = k - 1;
            }
            s = ns.toString().toCharArray();
        }
        return s.toString();
    }
}
