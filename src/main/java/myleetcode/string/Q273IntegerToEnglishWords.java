package myleetcode.string;

public class Q273IntegerToEnglishWords {
    private String[] small = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private String[] decade = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private String[] big = {"Billion", "Million", "Thousand", "Hundred"};

    public String numberToWords(int num) {
        if (num == 0) {
            return small[0];
        }
        StringBuffer sb = new StringBuffer("");
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, j++) {
            if (num >= i) {
                sb.append(getPart(num / i)).append(big[j]).append(" ");
                num %= i;
            }
        }

        return sb.toString().trim();
    }

    private String getPart(int num) {
        StringBuffer res = new StringBuffer("");
        if (num >= 100) {
            res.append(small[num / 100]).append(big[4]).append(" ");
            num %= 100;
        }
        if (num == 0) {
            return res.toString();
        }
        if (num >= 20) {
            res.append(decade[num / 10]).append(" ");
            num %= 10;
        }
        if (num == 0) {
            return res.toString();
        }
        res.append(small[num]).append(" ");
        return res.toString();
    }
}
