package microsoft;

public class Q14LongestCommonPrefix {
    public String longestCommonPrefix0(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int index = 0;
        boolean flag = false;
        char curChar;
        while (true) {
            if (index >= strs[0].length()) {
                break;
            }
            curChar = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (index >= str.length() || str.charAt(index) != curChar) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int cnt = strs.length;
        String preStr = strs[0];
        for (int i = 1; i < cnt; i++) {
            preStr = longestCommonPrefix(preStr, strs[i]);
            if (preStr.length() == 0) {
                return "";
            }
        }
        return preStr;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int index = 0;
        while (index < str1.length() && index < str2.length()) {
            if (str1.charAt(index) != str2.charAt(index)) {
                break;
            }
            index++;
        }
        return str1.substring(0, index);
    }

}
