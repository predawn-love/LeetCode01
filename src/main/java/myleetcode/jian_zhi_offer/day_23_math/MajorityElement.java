package myleetcode.jian_zhi_offer.day_23_math;

public class MajorityElement {
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }


    public int majorityElement(int[] nums) {
        int votes = 0;
        int mode = 0;
        for (int num : nums) {
            if (votes == 0) {
                mode = num;
            }
            votes += num == mode ? 1 : -1;
        }
        return mode;
    }
}
