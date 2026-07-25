class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int maxProfit =0;

        int buy=0;

        for(int i=1;i<n;i++){
            if(prices[buy]>prices[i]){
                buy=i;
            }
            else{
                maxProfit = Math.max(maxProfit, prices[i]-prices[buy]);
            }
        }

        return maxProfit;
    }
}

// time complexity
/*
O(n)
*/

// space complexity
/*
O(1)
*/