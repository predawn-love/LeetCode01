package microsoft;

public class Q121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // 该数组维护 i 位之前的股票价格最小值
        int n = prices.length;
        int preMin = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            preMin = Math.min(preMin, prices[i]);
            max = Math.max(prices[i] - preMin, max);
        }
        return max;
    }
}
