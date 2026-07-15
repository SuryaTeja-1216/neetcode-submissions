class Solution {
    public int[] productExceptSelf(int[] nums) {
        // optimal approach is to calculate the prefix array and suffix array 

        // [1,2,4,6] for 4 the product be all the elements before 4 and all the element after 4 
        // prefiz - 1,2 suffix - 6. which is prefix = 2 and suffix = 6 
        // the answer will product of 2 and 6 -> 12 which is product of prefix and suffix 
        // if we can store the product all the prefix elements before x and product of all the suffix elements after the x 
        // we can calculate the product of prefix and suffix and return the answers


        int n = nums.length;
        // creating the prefix array for the prefix array first element will be 1 because there wont be any value before 0 index and taking 0 as the default value will mess up the problem

        int[] prefixArray = new int[n];
        prefixArray[0] = 1;

        for(int i=1;i<n;i++){
            prefixArray[i] = prefixArray[i-1]*nums[i-1];
        }


        // creating the suffix array for the suffix array last element will be 1 because there wont be any value after n-1 index and taking 0 as the default value will mess up the problem
        int[] suffixArray = new int[n];

        suffixArray[n-1] = 1;

        for(int i=n-2;i>=0;i--){
            suffixArray[i] = suffixArray[i+1]*nums[i+1];
        }

        int[] resultArray = new int[n];

        for(int i=0;i<n;i++){
            resultArray[i] = prefixArray[i]*suffixArray[i];
        }

        return resultArray;
    }
}  

// time complexity 
/*
O(n) - prefix array
O(n) - suffix array

O(n) - result array

time total - O(3*n) ~ O(n)
*/

// space complexity
/*
O(n) - prefix array
O(n) - suffix array

time total - O(2*n) ~ O(n)

*/