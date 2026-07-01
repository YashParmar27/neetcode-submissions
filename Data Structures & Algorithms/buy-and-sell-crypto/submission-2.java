class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++)
        {
            int buy_price = prices[i];
            for (int j = i + 1; j < prices.length; j++)
            {
                int sell_price = prices[j];
                int curr_profit = sell_price - buy_price;
                if (curr_profit > profit)
                {
                    profit = curr_profit;
                }
            }
        }
        return profit;
    }  
}
