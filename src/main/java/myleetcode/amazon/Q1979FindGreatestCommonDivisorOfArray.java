package myleetcode.amazon;

public class Q1979FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd(max, min);
    }

//    private int gcd(int a, int b) {
//        return b != 0 ? gcd(b, a % b) : a;
//    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
