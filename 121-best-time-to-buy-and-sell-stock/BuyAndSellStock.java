public class BuyAndSellStock {
    public int maxProfit(int[] prices) {

        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[left]) {
                left = i;
            }
            max = Math.max(max, prices[i] - prices[left]);
        }
        return max;
    }
}

// time-complexity = O(n)
// space-complexity = O(1)