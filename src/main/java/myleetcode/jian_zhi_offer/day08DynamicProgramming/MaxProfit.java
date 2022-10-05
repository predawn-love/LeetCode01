package myleetcode.jian_zhi_offer.day08DynamicProgramming;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i : prices) {
            if (i <= minPrice) {
                minPrice = i;
                continue;
            }
            profit = Math.max(profit, i - minPrice);
        }
        return profit;
    }

}
