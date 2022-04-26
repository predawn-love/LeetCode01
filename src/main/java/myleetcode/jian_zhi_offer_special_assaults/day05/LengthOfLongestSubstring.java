package myleetcode.jian_zhi_offer_special_assaults.day05;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] flag = new int[256];
        int res = 0;
        int dif = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int curIndex = chars[i];
            while (flag[curIndex] != 0) {
                //  说明重复
                flag[chars[i - dif]] = 0;
                dif--;
            }

            //  说明不重复
            dif++;
            res = Math.max(dif, res);
            flag[curIndex] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 'a';
        System.out.println(a);
    }
}
