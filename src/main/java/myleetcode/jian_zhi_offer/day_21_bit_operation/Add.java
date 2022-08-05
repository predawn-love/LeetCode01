package myleetcode.jian_zhi_offer.day_21_bit_operation;

public class Add {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }



    public static void main(String[] args) {
        int add = new Add().add(9, 4);
        System.out.println(add);
    }
}
