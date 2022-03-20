package microsoft;

public class Q12IntToRoman {
//    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//
//    public String intToRoman(int num) {
//        StringBuffer roman = new StringBuffer();
//        for (int i = 0; i < values.length; ++i) {
//            int value = values[i];
//            String symbol = symbols[i];
//            while (num >= value) {
//                num -= value;
//                roman.append(symbol);
//            }
//            if (num == 0) {
//                break;
//            }
//        }
//        return roman.toString();
//    }

    /**
     * 方法1：模拟
     */
    // 我们寻找不超过 num 的最大符号值，将 num 减去该符号值，然后继续寻找不超过 num 的最大符号值
    // 所以我们在这里必须从大到小降序排列。
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }




    /**
     * 方法2：硬编码表
     */
//    String[] thousands = {"", "M", "MM", "MMM"};
//    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//
//    public String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(thousands[num / 1000]);
//        sb.append(hundreds[num % 1000 / 100]);
//        sb.append(tens[num % 100 / 10]);
//        sb.append(ones[num % 10]);
//        return sb.toString();
//    }
}
