package myleetcode.microsoft;

public class Q1822ArraySign {
    public int arraySign(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            } else if (i < 0) {
                count++;
            }
        }
        return (count & 1) == 0 ? 1 : -1;
    }
}
