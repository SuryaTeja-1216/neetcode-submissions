class Solution {
    public int maxProfit(int[] prices) {
        // implementing dp
        // where you remember value and use it in the entire array
        // in this problem we will remember the buy price and when you see the buy less than the min you update the buy

        int buy = 0;
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            // System.out.println(buy);
            maxProfit = Math.max(maxProfit, prices[i]-prices[buy]);

            if(prices[buy]>prices[i]) buy = i;
        }

        return maxProfit;
    }
}
