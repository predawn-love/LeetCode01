package myleetcode.programmer_interview_golden_code;

public class Q01_01 {
    public boolean isUnique(String astr) {
        int num = 0;
        for (char c : astr.toCharArray()) {
            int temp = 1 << (c - 'a');
            if ((num & temp) == 0) {
                num |= temp;
            } else {
                return false;
            }
        }
        return true;
    }
}
