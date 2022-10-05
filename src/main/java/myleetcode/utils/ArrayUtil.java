package myleetcode.utils;

public class ArrayUtil {
    /**
     * 将大、小括号转成中括号。
     */
    public static String turnToSquareBrackets(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                    sb.append('[');
                    break;
                case ')':
                case '}':
                    sb.append(']');
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将中、小括号转成大括号。
     */
    public static String turnToBigBrackets(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                case '(':
                    sb.append('{');
                    break;
                case ')':
                case ']':
                    sb.append('}');
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将中括号和英文逗号分隔的字符串转化成二维int数组
     *
     * @param str 例："[[3,0],[3,1]]"
     * @return 对应的二维数组 [[3,0],[3,1]]
     */
    public static int[][] get2DIntArrayBySquareBrackets(String str) {
        String[] split1 = str.substring(2, str.length() - 2).split("],\\[");
        int[][] ints = new int[split1.length][];
        int i = 0;
        for (String s : split1) {
            String[] strings = s.split(",");
            ints[i] = new int[strings.length];
            int j = 0;
            for (String s2 : strings) {
                ints[i][j++] = Integer.valueOf(s2);
            }
            i++;
        }
        return ints;
    }
}
