package myleetcode.jian_zhi_offer.day16sort;

public class MinNumber {
//    public String minNumber(int[] nums) {
//        String[] strings = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            strings[i] = String.valueOf(nums[i]);
//        }
////        Arrays.sort(strings, (x, y) -> (String.format("%s%s", x, y).compareTo(String.format("%s%s", y, x))));
//        Arrays.sort(strings, (x, y) -> ((x + y).compareTo(y + x)));
//        StringBuilder res = new StringBuilder();
//        for (String s : strings) {
//            res.append(s);
//        }
//        return res.toString();
//    }

    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strings) {
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            // 先走的 j 所以 j 每次停下时一定指向应该放在 strs[l] 左侧的 或者是和 i 重叠
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
