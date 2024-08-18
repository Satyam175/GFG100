package Array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 2, 11, 1 ,6 ,4,1};
        System.out.println(maxProfit(6, prices));
    }

    public static int maxProfit(int n, int[] prices) {
        int buy = prices[0], max_profit = 0;
        for (int i = 1; i < n; i++) {
            // Checking for lower buy value
            if (buy > prices[i])
                buy = prices[i];

            // Checking for higher profit
            max_profit = Math.max(max_profit, prices[i] - buy);
        }
        return max_profit;
    }
}
