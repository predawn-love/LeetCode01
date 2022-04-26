package myleetcode.jian_zhi_offer.day16sort;

import java.util.HashSet;
import java.util.Set;

public class IsStraight {
    /**
     * 1、不能重复  2、 max - min < 5
     * 0,0,1,2,5  缺 3,4   5 - 1 < 5
     * 0,0,3,2,7  缺 4,5,6  7 - 2 = 5
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i == 0) {
                continue;
            }
            if (!set.add(i)) {
                return false;
            }
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        return  max - min < 5;
    }
}
