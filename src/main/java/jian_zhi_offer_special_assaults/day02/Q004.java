package jian_zhi_offer_special_assaults.day02;

public class Q004 {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        for (int i : nums) {
            once = (i ^ once) & ~twice;
            twice = (i ^ twice) & ~once;
        }
        return once;
    }
}
