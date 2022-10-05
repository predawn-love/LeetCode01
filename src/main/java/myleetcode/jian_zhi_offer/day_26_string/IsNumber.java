package myleetcode.jian_zhi_offer.day_26_string;

import java.util.HashMap;
import java.util.Map;

public class IsNumber {
//    public boolean isNumber(String s) {
//        char[] chars = s.toCharArray();
//        int curIndex = 0;
//        s = s.trim();
//        if (s.charAt(curIndex) == '+' || s.charAt(curIndex) == '-') {
//            s = s.substring(1);
//        }
//        String[] split = s.split("[e|E]");
//        if (split.length > 2) {
//            return false;
//        }
////        if ()
//        return true;
//    }

    /**
     * 有限状态自动机： 字符类型： 空格' '，数字'd'，正负号's'，小数点'.'，幂符号'e'
     * 状态定义：按照字符串从左到右的顺序定义9种状态：
     *
     * 0：开始的空格
     * 1：正负号
     * 2：小数点前的数字
     * 3：小数点及之后的数字
     * 4、空格后的小数点
     * 5、幂符号
     * 6、幂符号后的正负号
     * 7、幂符号后的数字
     * 8、结尾的空格
     * 其中2、3、7、8为有效的最终状态
     */
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{put(' ', 0); put('s', 1); put('d', 2); put('.', 4);}},
                new HashMap() {{put('d', 2); put('.', 4); }},
                new HashMap() {{put('d', 2); put('.', 3); put('e', 5); put(' ', 8);}},
                new HashMap() {{put('d', 3); put('e', 5); put(' ', 8);}},    // 3
                new HashMap() {{put('d', 3); }},    //  4
                new HashMap() {{put('d', 7); put('s', 6);}},    //  5
                new HashMap() {{put('d', 7); }},    //  6
                new HashMap() {{put('d', 7); put(' ', 8);}},    // 7
                new HashMap() {{put(' ', 8);}}, //  8
        };
        int p = 0;
        char[] chars = s.toCharArray();
        char t;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == ' ' || c == '.') {
                t = c;
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else {
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }


    public static void main(String[] args) {
        String s = "111e5";
        String[] split = s.split("[e|E]");
        Double integer = Double.valueOf(s);
        int[] a = {0, 1};
        int[] a2 = new int[]{0, 1};
        System.out.println("--");
    }
}
