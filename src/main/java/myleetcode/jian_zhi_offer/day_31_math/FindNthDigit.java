package myleetcode.jian_zhi_offer.day_31_math;

public class FindNthDigit {
    /**
     * 暴力模拟，失败。
     */
//    public int findNthDigit(int n) {
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        while (sb.length() < n + 1) {
//            sb.append(i++);
//        }
//        return sb.charAt(n) - '0';
//    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0';    // 3.
    }

    public static void main(String[] args) {
        new FindNthDigit().findNthDigit(19);
    }
}
