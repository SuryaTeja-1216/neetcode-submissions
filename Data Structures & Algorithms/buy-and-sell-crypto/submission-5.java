class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit= 0;
        
        int n = prices.length;
        for(int i=0;i<n;i++){
            int tempProfit = 0;
            for(int j=i+1;j<n;j++){
                tempProfit = Math.max(tempProfit, prices[j]-prices[i]);
            }
            maxProfit=Math.max(maxProfit, tempProfit);
        }

        return maxProfit;
    }
}

// brute force

//time complexity
/*
O(n^2)
*/

// space complexity 
/*
O(1)
*/
