package myleetcode.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Q151ReverseWordsInAString {
    /**
     * 1、调用API
     */
//    public String reverseWords(String s) {
//        s = s.trim();
//        List<String> wordList = Arrays.asList(s.split("\\s+"));
//        Collections.reverse(wordList);
//        return String.join(" ", wordList);
//    }

    /**
     * 2、我自己写的SB
     */
//    public String reverseWords(String s) {
//        s = s.trim();
//        String[] strings = s.split("\\s+");
//        StringBuffer sb = new StringBuffer("");
//        for (int i = strings.length - 1; i >= 0 ; i--) {
//            if (i == 0) {
//                sb.append(strings[i]);
//            } else {
//                sb.append(strings[i]).append(" ");
//            }
//        }
//        return sb.toString();
//    }

    /**
     * 3、正儿八经考验基本功。
     */
    public String reverseWords(String s) {
        if (null == s) {
            return null;
        }
        char[] chars = s.toCharArray();
        int len = 0;    // 字符串的最终有效长度，末有效位为 len - 1
        int cur = 0;    // 当前用来存放字符的位置
        boolean space = true;   // 前一个字符是否为空格字符

        // 原地消除多余空格
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (!space) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        // 若 space 为真，说明末尾有一个空格
        len = space ? cur - 1 : cur;
        // 对应空字符串
        if (len <= 0) {
            return null;
        }

        // 对整个字符串进行翻转
        reverse(chars, 0, len);
        // 对每一个单词进行翻转
        int preSpaceIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') {
                continue;
            }
            reverse(chars, preSpaceIndex + 1, i);
            preSpaceIndex = i;
        }
        reverse(chars, preSpaceIndex + 1, len);
        return new String(chars, 0, len);
    }

    private void reverse(char[] chars, int l, int r) {
        r--;
        while (l < r) {
            char t = chars[l];
            chars[l++] = chars[r];
            chars[r--] = t;
        }
    }

    public static void main(String[] args) {
        String s = "aas  asdf    sdf";
        String[] strings = s.split("(\\s+)");
    }
}
