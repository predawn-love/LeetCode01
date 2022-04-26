package myleetcode.microsoft;

public class Q11MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            res = Math.max(res, (r - l) * Math.min(height[r], height[l]));
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
