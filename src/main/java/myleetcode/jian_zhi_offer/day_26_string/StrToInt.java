package myleetcode.jian_zhi_offer.day_26_string;

public class StrToInt {
    /**
     * 自己写的方法
     */
//    private static String MIN_INTEGER = String.valueOf(Integer.MIN_VALUE);
//    private static String MAX_INTEGER = String.valueOf(Integer.MAX_VALUE);
//
//    public int strToInt(String str) {
//        str = str.trim();
//        if (str.length() == 0) {
//            return 0;
//        }
//        boolean isPositive = true;
//        if (str.charAt(0) == '-') {
//            isPositive = false;
//            str = str.substring(1);
//        } else if (str.charAt(0) == '+'){
//            str = str.substring(1);
//        }
//        char[] chars = str.toCharArray();
//
//        int endIndex = 0;
//        int startIndex = 0;
//        boolean needToMoveStart = true;
//        for (char c : chars) {
//            if (needToMoveStart && c == '0') {
//                startIndex++;
//                endIndex++;
//                continue;
//            } else {
//                needToMoveStart = false;
//            }
//            if (c >= '0' && c <= '9') {
//                endIndex++;
//            } else {
//                break;
//            }
//        }
//        str = str.substring(startIndex, endIndex);
//        String string = str;
//        if (!isPositive) {
//            string = "-" + string;
//        }
//        if (!isPositive && (string.length() > MIN_INTEGER.length() || string.length() == MIN_INTEGER.length() && string.compareTo(MIN_INTEGER) > 0)) {
//            return Integer.MIN_VALUE;
//        }
//        if (isPositive && (string.length() > MAX_INTEGER.length() || (string.length() == MAX_INTEGER.length() && string.compareTo(MAX_INTEGER) > 0))) {
//            return Integer.MAX_VALUE;
//        }
//        chars = str.toCharArray();
//        int res = 0;
//        for (int i = chars.length - 1, power = 1; i >= 0; i--) {
//            res += (chars[i] - '0') * power;
//            power *= 10;
//        }
//        if (isPositive) {
//            return res;
//        } else {
//            return -res;
//        }
//    }

    /**
     * K神的方法：
     */
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int res = 0, boundary = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            if (res > boundary || (res == boundary && chars[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + chars[j] - '0';
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String str = "123\\d1s1";
        int i = str.indexOf("\\d");

        String s1 = "-2147483648";
        String s2 = "-2147483649";
        System.out.println(s1.compareTo(s2));

        String s3 = "2147483647";
        String s4 = "2147483648";
        System.out.println(s3.compareTo(s4));

        int i1 = new StrToInt().strToInt("    +11191657170");
        System.out.println(i1);
    }
}
