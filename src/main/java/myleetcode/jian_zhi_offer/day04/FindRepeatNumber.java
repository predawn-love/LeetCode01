package myleetcode.jian_zhi_offer.day04;

public class FindRepeatNumber {
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        int res = -1;
//        for (int num : nums) {
//            if (!set.add(num)) {
//                res = num;
//                break;
//            }
//        }
//        return res;
//    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内，所以说明只要有重复数字，则索引值对数字为1对多的关系
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 如果当前数字和索引值相同，说明在应有的位置继续循环
            if (nums[i] == i) {
                i++;
                continue;
            }
            // 相同则说明有重复
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            // 不同则交换，然后重复。
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}











