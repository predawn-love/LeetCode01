package myleetcode.jian_zhi_offer.day_26_string;

public class StrToIntMyself {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        int i = 1;
        int sign = 1;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] == '+') {
            i = 0;
        }
        while (i < chars.length) {

            i++;
        }
        return sign * res;
    }
}
