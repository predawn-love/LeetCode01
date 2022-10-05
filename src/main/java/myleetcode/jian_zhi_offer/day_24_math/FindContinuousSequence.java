package myleetcode.jian_zhi_offer.day_24_math;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
//    public int[][] findContinuousSequence(int target) {
//        ArrayList<List<Integer>> resList = new ArrayList<>();
//        LinkedList<Integer> tempAnswer = new LinkedList<>();
//        int sum = 0;
//        for (int i = 1; i <= target / 2 + 2; i++) {
//            if (sum < target) {
//                tempAnswer.addLast(i);
//                sum += i;
//            } else if (sum == target) {
//                resList.add(new LinkedList<>(tempAnswer));
//                sum -= tempAnswer.pollFirst();
//                i--;
//            } else {
//                sum -= tempAnswer.pollFirst();
//                i--;
//            }
//        }
//        int[][] ans = new int[resList.size()][];
////        int i = 0;
////        for (List<Integer> x : resList) {
////            int[] ints = x.stream().mapToInt(Integer::valueOf).toArray();
////            ans[i++] = ints;
////        }
//        for (int i = 0; i < resList.size(); i++) {
//            List<Integer> temp = resList.get(i);
//            int[] ints = new int[temp.size()];
//            for (int j = 0; j < temp.size(); j++) {
//                ints[j] = temp.get(j);
//                ans[i] = ints;
//            }
//        }
//        return ans;
//    }


    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (sum == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            if (sum > target) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }
        return res.toArray(new int[0][]);
    }



    public static void main(String[] args) {
        new FindContinuousSequence().findContinuousSequence(9);
    }
}
