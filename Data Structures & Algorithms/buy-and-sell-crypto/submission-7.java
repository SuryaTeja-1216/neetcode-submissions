class Solution {
    public int maxProfit(int[] prices) {

        // sliding window dynamic size

        // every time window size increases to the right but when buy > sell we will shrink left window to right 
        int n=prices.length;

        int buy =0;
        int sell = 1;

        int maxProfit = 0;

        while(sell<n){
            if(prices[buy]<=prices[sell]){
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
            else{
                buy = sell;
            }
            sell++;
        }

        return maxProfit;

    }
}

// time complexity
/*
O(n)
*/

//space complexity
/*
O(1)
*/