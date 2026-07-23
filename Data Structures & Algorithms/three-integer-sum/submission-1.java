class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // we need to find the triplet where nums[i]+nums[j]+nums[k]=0
        // if i is the first element and we modify the equation to nums[j]+nums[k] = -nums[i];
        // if we take nums[i] as target and find the pairs whose sum is equal to -ve(nums[i]);

        // but you i and find pair j & k for 2 sum you will end up having O(n^3)
        // instead sort the array take first element as i and do binary search on the rest of the space
        // move i till n-2

        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> tripletsResult = new ArrayList<>();


        // HashSet<List<Integer>> uniqueTriplets = new HashSet<>();

        for(int i=0;i<n-2;i++){
            // perform binary search on the rest of i+1 to n

            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            int target= -nums[i];



            

            while(j<k){
                ArrayList<Integer> temp = new ArrayList<>();
                if(nums[j]+nums[k]==target){
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    // if(!uniqueTriplets.contains(temp)){
                    //     tripletsResult.add(temp);
                    //     uniqueTriplets.add(temp);
                    // }
                    tripletsResult.add(temp);
                    // break;
                    
                    while(j<k && nums[j]==nums[j+1]) j++;
                    

                    while(j<k && nums[k]==nums[k-1])k--;
                    
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k]>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }

        return tripletsResult;

    }
}

// time complexity 
/*
O(n*nlogn)
*/

// space complexity 
/*
O(1)
*/

// ============================================================================
// TIME COMPLEXITY ANALYSIS: O(n^2)
// ============================================================================
// 1. Sorting Step: Arrays.sort(nums) takes O(n log n) time.
//    - Note: This sorting step happens ONLY ONCE at the beginning of the function,
//      NOT inside the loop.
//
// 2. Two-Pointer Loop:
//    - Outer loop ('i') runs 'n' times (from 0 to n-3).
//    - Inner 'while(j < k)' loop: In each step, either 'j' increases or 'k' decreases.
//      Together, 'j' and 'k' cover at most 'n' elements for a fixed 'i'.
//      So, the inner two-pointer search takes O(n) time.
//
// 3. Total Time = Sorting + Loop Execution
//               = O(n log n) + O(n * n)
//               = O(n log n) + O(n^2)
//               = O(n^2)  [Since O(n^2) dominates O(n log n)]
//
// WHY IT IS NOT O(n * n log n):
// - O(n * n log n) would only occur if you called Arrays.sort(...) INSIDE 
//   the outer loop for every iteration of 'i'. 
// - Because sorting is executed outside the loop, its cost is ADDED (O(n log n) + O(n^2)), 
//   not MULTIPLIED (O(n) * O(n log n)).
// ============================================================================


// ============================================================================
// SPACE COMPLEXITY ANALYSIS: O(1) or O(n) depending on context
// ============================================================================
// 1. Auxiliary Space: O(1)
//    - We only use a few integer variables ('i', 'j', 'k', 'target', 'n') to track 
//      pointers and targets, which take O(1) constant extra memory.
//
// 2. Sorting Space: O(1) to O(n)
//    - Depending on the language and sorting algorithm implementation:
//      * Dual-Pivot Quicksort in Java primitives uses O(log n) extra stack space.
//      * Timsort (for objects) uses O(n) extra space.
//
// 3. Output Space:
//    - The space required for 'tripletsResult' is typically ignored when calculating 
//      auxiliary space complexity, as it is required for the output return value.
// ============================================================================