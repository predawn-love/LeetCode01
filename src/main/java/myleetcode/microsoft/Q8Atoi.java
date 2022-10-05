package myleetcode.microsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Q8Atoi {
    private static final Logger LOGGER = LoggerFactory.getLogger(Q8Atoi.class);

    public int myAtoi(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean isPositive = true;
        int beginIndex = 0;

        // 1、去除前导空格
        while (beginIndex < chars.length && chars[beginIndex] == ' ') {
            beginIndex++;
        }

        // 2、判断是否有正负号，有的话后移索引位一位。
        if (beginIndex < chars.length && chars[beginIndex] == '-') {
            isPositive = false;
            beginIndex++;
        } else if (beginIndex < chars.length && chars[beginIndex] == '+') {
            beginIndex++;
        }

        // 3、非数字返回 0
        if (beginIndex < chars.length && isNotNum(chars[beginIndex])) {
            return 0;
        }

        // 4、移除前导零
        while (beginIndex < chars.length && chars[beginIndex] == '0') {
            beginIndex++;
        }

        // 找到之后第一个非数字字符所在的索引位。
        int endIndex = beginIndex;
        while (endIndex < chars.length && !isNotNum(chars[endIndex])) {
            endIndex++;
        }
        LOGGER.info("length = {}", str.length());
        LOGGER.info("beginIndex = {}, endIndex = {}", beginIndex, endIndex);

        // 现在endIndex 指向第一个非数字字符
        int ans = 0;
        while (beginIndex < endIndex) {
            int i = chars[beginIndex] - '0';
            if (isPositive) {
                if ((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && i > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if ((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && i > (Integer.MAX_VALUE % 10 + 1))) {
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + i;
            beginIndex++;
        }
        return isPositive ? ans : -ans;
    }

    private boolean isNotNum(char chars) {
        return chars > '9' || chars < '0';
    }

    public static void main(String[] args) {
//        int notNum = new Q8Atoi().myAtoi("    -0042");
        int notNum = new Q8Atoi().myAtoi("    ");
        System.out.println(notNum);
    }
}
