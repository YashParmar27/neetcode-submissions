class Solution {
    public int maxProfit(int[] prices){
        int profit = 0;
        int buying_price = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            int selling_price = prices[i];
            if (prices[i - 1] < buying_price)
                buying_price = prices[i - 1];

            int curr_profit = selling_price - buying_price;
            if (curr_profit > profit)
                profit = curr_profit;
        }
        return profit;
    }  
}
