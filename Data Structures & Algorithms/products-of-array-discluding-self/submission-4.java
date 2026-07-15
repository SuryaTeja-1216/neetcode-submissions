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

        // optimal is to use the result array and calculate the prefix and use the same to update the suffix product 
        int[] resultArray = new int[n];
        resultArray[0] = 1;

        for(int i=1;i<n;i++){
            resultArray[i] = resultArray[i-1]*nums[i-1];
        }


        // creating the suffix array for the suffix array last element will be 1 because there wont be any value after n-1 index and taking 0 as the default value will mess up the problem
        // instead of suffix array just keep variable which store all products from back

        int suffixVal = 1;

        for(int i=n-1;i>=0;i--){
            resultArray[i] = resultArray[i]*suffixVal;
            suffixVal*=nums[i];
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
no extra space other than the result 

O(1)
*/


// Example Input: nums = [1, 2, 4, 6]
// We initialize a result array of the same size: result = [0, 0, 0, 0]

// --- PASS 1: Calculate Prefix Products ---
// We use a variable 'prefix' initialized to 1.
// We iterate from left to right.

// i = 0 | nums[0] = 1
// result[0] gets the current prefix: 1
// Update prefix: prefix * nums[0] = 1 * 1 = 1
// result is now: [1, 0, 0, 0]

// i = 1 | nums[1] = 2
// result[1] gets the current prefix: 1
// Update prefix: prefix * nums[1] = 1 * 2 = 2
// result is now: [1, 1, 0, 0]

// i = 2 | nums[2] = 4
// result[2] gets the current prefix: 2
// Update prefix: prefix * nums[2] = 2 * 4 = 8
// result is now: [1, 1, 2, 0]

// i = 3 | nums[3] = 6
// result[3] gets the current prefix: 8
// Update prefix: prefix * nums[3] = 8 * 6 = 48
// result is now: [1, 1, 2, 8]


// --- PASS 2: Calculate Suffix Products ---
// We use a variable 'suffix' initialized to 1.
// We iterate from right to left, MULTIPLYING against what is already in 'result'.

// i = 3 | nums[3] = 6
// result[3] = result[3] * suffix = 8 * 1 = 8
// Update suffix: suffix * nums[3] = 1 * 6 = 6
// result is now: [1, 1, 2, 8]

// i = 2 | nums[2] = 4
// result[2] = result[2] * suffix = 2 * 6 = 12
// Update suffix: suffix * nums[2] = 6 * 4 = 24
// result is now: [1, 1, 12, 8]

// i = 1 | nums[1] = 2
// result[1] = result[1] * suffix = 1 * 24 = 24
// Update suffix: suffix * nums[1] = 24 * 2 = 48
// result is now: [1, 24, 12, 8]

// i = 0 | nums[0] = 1
// result[0] = result[0] * suffix = 1 * 48 = 48
// Update suffix: suffix * nums[0] = 48 * 1 = 48
// result is now: [48, 24, 12, 8]

// Final Output Matches Expected: [48, 24, 12, 8]