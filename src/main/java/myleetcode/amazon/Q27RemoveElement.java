package myleetcode.amazon;

public class Q27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        int end = 0;
        while (cur < nums.length) {
            if (nums[cur] == val) {
                cur++;
            } else {
                nums[end] = nums[cur];
                end++;
            }
        }
        return nums.length - cur + end;
    }
}
