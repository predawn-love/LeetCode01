package myleetcode.string;

public class Q6ZigZagConversion {
    public String convert(String s, int numRows) {
        // n 为 1 的话，下面循环公差为零，死循环
        if (numRows == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer("");
        char[] ch = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < ch.length; j += 2 * (numRows - 1)) {
                    sb.append(ch[j]);
                }
            } else {
                for (int j = i, k = 2 * (numRows - 1) - i; j < ch.length || k < ch.length; j += 2 * (numRows - 1), k += 2 * (numRows - 1)) {
                    sb.append(ch[j]);
                    if (k < ch.length) {
                        sb.append(ch[k]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
