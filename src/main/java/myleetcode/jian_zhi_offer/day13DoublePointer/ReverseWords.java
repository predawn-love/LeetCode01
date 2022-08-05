package myleetcode.jian_zhi_offer.day13DoublePointer;

public class ReverseWords {

    /**
     * 自己写的性能很慢
     */
//    public String reverseWords(String s) {
//        LinkedList<String> res = new LinkedList<>();
//        while (s.length() != 0) {
//            s = s.trim();
//            int i = s.indexOf(" ");
//            if (i == -1) {
//                res.addFirst(s);
//                break;
//            } else {
//                res.addFirst(s.substring(0, i));
//            }
//            s = s.substring(i + 1);
//        }
//        return String.join(" ", res).trim();
//    }

    /**
     * 用split
     */
//    public String reverseWords(String s) {
//        String[] strs = s.trim().split(" ");
//        StringBuilder res = new StringBuilder();
//        for (int i = strs.length - 1; i >= 0; i--) {
//            if ("".equals(strs[i])) {
//                continue;
//            }
//            res.append(strs[i]).append(" ");
//        }
//        return res.toString().trim();
//    }

    /**
     *  双指针
     */
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索空格
            while (i >= 0 && chars[i] != ' ') {
                i--;
            }
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            // 跳过单词间空格
            while (i >= 0 && chars[i] == ' ') {
                i--;
            }
            // j指向下个单词的尾词符
            j = i;
        }
        return res.toString().trim();
    }
}
