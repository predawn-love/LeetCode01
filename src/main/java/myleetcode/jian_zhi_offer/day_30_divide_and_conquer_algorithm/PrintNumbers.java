package myleetcode.jian_zhi_offer.day_30_divide_and_conquer_algorithm;

public class PrintNumbers {
    /**
     * 不考虑大数，简单题
     */
//    public int[] printNumbers(int n) {
//        if (n <= 0) {
//            return new int[]{};
//        }
//        int[] res = new int[(int) Math.pow(10, n) - 1];
//        for (int i = 1; i <= res.length; i++) {
//            res[i - 1] = i;
//        }
//        return res;
//    }


    /**
     * String 以应对大数
     */
//    private StringBuilder res;
//    private int n;
//    private int start;
//    private int nine = 0;
//    private int count = 0;
//    private char[] num;
//    private char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//    public String printNumbers(int n) {
//        this.n = n;
//        res = new StringBuilder();
//        num = new char[n];
//        start = n - 1;
//        dfs(0);
//        res.deleteCharAt(res.length() - 1);
//        return res.toString();
//    }
//
//    private void dfs(int x) {
//        if (x == n) {
//            // 终止条件：已固定完所有位
//            String s = String.valueOf(num).substring(start);
//            if (!"0".equals(s)) {
//                res.append(s).append(","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
//            }
//            if (n - start == nine) {
//                start--;
//            }
//            return;
//        }
//        for (char c : loop) {
//            if (c == '9') {
//                nine++;
//            }
//            num[x] = c;
//            dfs(x + 1);
//        }
//        nine--;
//    }


    /**
     * 应对大数的 int[] 返回
     */
    private int[] res;
    private int n;
    private int start;
    private int nine = 0;
    private int count = 0;
    private char[] num;
    private char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[]{};
        }
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if (x == n) {
            // 终止条件：已固定完所有位
            String s = String.valueOf(num).substring(start);
            if (!"0".equals(s)) {
                res[count++] = Integer.valueOf(s); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            }
            if (n - start == nine) {
                start--;
            }
            return;
        }
        for (char c : loop) {
            if (c == '9') {
                nine++;
            }
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        int[] res = new PrintNumbers().printNumbers(2);
        for (int i : res) {
            System.out.print(i + ",");
        }
        System.out.println(res);
    }
}
