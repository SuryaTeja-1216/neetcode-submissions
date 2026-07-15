class Solution {
    public int[] productExceptSelf(int[] nums) {
        // brute iterate through the array and for every element calculate the product of all elements 
        // excluding the current element

        int n = nums.length;

        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i]=1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    result[i]*=nums[j];
                }
            }
        }

        return result;
    }
}  

// time complexity 
/*
O(n^2) for every element we iterate through the entire array and calculate the product 
*/

// space complexity 
/*
expected output is a new array so we are not using any auxiliary space 
*/