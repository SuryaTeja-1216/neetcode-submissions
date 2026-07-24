class Solution {
    public int maxArea(int[] heights) {
        
        int n= heights.length;
        int i=0;
        int j=n-1;

        int maxArea = 0;
        while(i<j){
            maxArea = Math.max(maxArea, (j-i)*Math.min(heights[i],heights[j]));
            if(heights[i]<heights[j])i++;
            else j--;
            

            // i++;
            // j--;
        }

        return maxArea;
    }
}

// time compelxity 
/*
O(n)
*/

// space complexity 
/*
O(1)
*/

// ============================================================================
// WHY CAN WE MOVE EITHER POINTER WHEN HEIGHTS ARE EQUAL?
// ============================================================================
// If heights[i] == heights[j] (e.g., both are 5), the current area is the 
// absolute maximum we can get using EITHER of these specific bars. 
// 
// Why? 
// Let's say we move 'j' inward (j--) but keep 'i' where it is.
// 1. Our width just decreased.
// 2. The water height is STILL capped by heights[i] (which is 5). 
// 
// Even if the new 'j' is a massive bar of height 100, the water level 
// cannot exceed 5. Since width is smaller and height cannot increase, 
// the new area will ALWAYS be smaller than the area we just calculated.
// 
// Therefore, it is mathematically safe to discard either bar (i++ or j--) 
// when they are equal, without any risk of missing a larger container!
// ============================================================================