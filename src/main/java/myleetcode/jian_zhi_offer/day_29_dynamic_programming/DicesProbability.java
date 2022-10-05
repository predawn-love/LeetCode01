package myleetcode.jian_zhi_offer.day_29_dynamic_programming;

import java.util.*;

public class DicesProbability {
    /**
     * 暴力模拟，效率极低
     */
//    public double[] dicesProbability(int n) {
//        Map<Integer, Integer> sumVsFrequency = new LinkedHashMap<>();
//        for (int k = 1; k <= 6; k++) {
//            sumVsFrequency.put(k, 1);
//        }
//
//        for (int i = 1; i < n; i++) {
//            Map<Integer, Integer> tempMap = new LinkedHashMap<>();
//            Set<Map.Entry<Integer, Integer>> entries = sumVsFrequency.entrySet();
//            for (Map.Entry<Integer, Integer> entry : entries) {
//                for (int k = 1; k <= 6; k++) {
//                    tempMap.put(entry.getKey() + k, tempMap.getOrDefault( entry.getKey() + k,0) + entry.getValue());
//                }
//            }
//            sumVsFrequency = tempMap;
//        }
//        double[] doubles = new double[sumVsFrequency.size()];
//
//        int index = 0;
//        int sum = 0;
//        for (Integer integer : sumVsFrequency.values()) {
//            sum += integer.intValue();
//        }
//        for (Integer integer : sumVsFrequency.values()) {
//            doubles[index++] = integer.doubleValue() / sum;
//        }
//        return doubles;
//    }


    /**
     * dp
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[dp.length + 5];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        double[] doubles = new DicesProbability().dicesProbability(3);
        double sum = 0;
        for (double d : doubles) {
            sum += d;
        }
        System.out.println(sum);

        double[] ds = {0.00463,0.01389,0.02778,0.04630,0.06944,0.09722,0.11574,0.12500,0.12500,0.11574,0.09722,0.06944,0.04630,0.02778,0.01389,0.00463};
        double sum1 = 0;
        for (double d : ds) {
            sum1 += d;
        }
        System.out.println(sum1);
    }
}
