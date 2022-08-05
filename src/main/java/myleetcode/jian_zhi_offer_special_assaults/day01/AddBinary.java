package myleetcode.jian_zhi_offer_special_assault.day01;

public class AddBinary {
//    public String addBinary(String a, String b) {
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] charsA = a.toCharArray();
//        char[] charsB = b.toCharArray();
//        int curA = a.length() - 1;
//        int curB = b.length() - 1;
//        int carry = 0;
//        int sum;
//        int cA;
//        int cB;
//        while (curA >= 0 && curB >= 0) {
//            cA = charsA[curA] - '0';
//            cB = charsB[curB] - '0';
//            sum = cA ^ cB ^ carry;
//            carry = (cA & cB) | (carry & cB) | (cA & carry);
//            stringBuilder.append(sum);
//            curA--;
//            curB--;
//        }
//        while (curA >= 0) {
//            cA = charsA[curA] - '0';
//            sum = cA ^ carry;
//            carry = cA & carry;
//            stringBuilder.append(sum);
//            curA--;
//        }
//        while (curB >= 0) {
//            cB = charsB[curB] - '0';
//            sum = cB ^ carry;
//            carry = cB & carry;
//            stringBuilder.append(sum);
//            curB--;
//        }
//        if ((carry & 1) != 0) {
//            stringBuilder.append(1);
//        }
//        return stringBuilder.reverse().toString();
//    }

    /**
     * 三元表达式优化一下
     */
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int curA = a.length() - 1;
        int curB = b.length() - 1;
        int carry = 0;
        int sum;
        while (curA >= 0 || curB >= 0 || carry > 0) {
            sum = carry;
            sum += curA >= 0 ? charsA[curA] - '0' : 0;
            sum += curB >= 0 ? charsB[curB] - '0' : 0;
            stringBuilder.append(sum % 2);
            carry = sum > 1 ? 1 : 0;
            curA--;
            curB--;
        }
        return stringBuilder.reverse().toString();
    }
}
