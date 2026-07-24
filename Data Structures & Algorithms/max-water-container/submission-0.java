class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;
        
        for(int i=0;i<n;i++){
            int tempMaxArea=0;
            for(int j=i+1;j<n;j++){
                int area = j-i;
                area*= Math.min(heights[i],heights[j]);
                tempMaxArea = Math.max(tempMaxArea, area);
            }

            maxArea = Math.max(maxArea, tempMaxArea);
        }

        return maxArea;
    }
}

// time complexity 
/*
O(n^2)
*/

// space complexity 
/*
O(1)
*/
