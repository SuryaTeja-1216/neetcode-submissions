class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> mapOfNums = new HashMap<>();

        for(int key:nums){
            mapOfNums.put(key,0);
        }

        int longestConsecutiveSequence = 0;
        for(int i=0;i<nums.length;i++){
            int ele = nums[i];

            // GATEKEEPER: Only enter if 'ele' is the absolute START of a sequence.
            // If (ele - 1) exists in the map, 'ele' is part of a sequence but not the start.
            // Skipping this prevents the O(n^2) redundant scanning of sub-sequences.
            if(!mapOfNums.containsKey(ele-1)){
                int count =0;

                // Traverse forward from the start of the sequence.
                // The 'get(ele) == 0' check prevents duplicate values from re-running this loop.
                while(mapOfNums.containsKey(ele) && mapOfNums.get(ele)==0){
                    count++;
                    mapOfNums.put(ele,1);
                    ele++;
                }
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, count);
                mapOfNums.put(nums[i], 1);
            }
        }

        return longestConsecutiveSequence;
    }
}


// time complexity 
/*
O(2*n) ~ O(n)
*/

// space complexity
// O(n)

// =========================================================================
// TIME COMPLEXITY EXPLANATION: Longest Consecutive Sequence
// =========================================================================
//
// TEST CASE TRACE: [6, 5, 4, 3, 2, 12, 11, 10, 9, 8]  (n = 10)
//
// 1. WITHOUT THE (ele - 1) CHECK -> O(n^2)
// -------------------------------------------------------------------------
// If we blindly run the inner loop for every single number, we do massive 
// amounts of redundant work by scanning overlapping sub-sequences.
//
// For example, given a descending array [5, 4, 3, 2, 1]:
// - For 5: Checks 5 -> 6?                      (1 check)
// - For 4: Checks 4 -> 5 -> 6?                 (2 checks)
// - For 3: Checks 3 -> 4 -> 5 -> 6?            (3 checks)
// - For 2: Checks 2 -> 3 -> 4 -> 5 -> 6?       (4 checks)
// - For 1: Checks 1 -> 2 -> 3 -> 4 -> 5 -> 6?  (5 checks)
//
// Total Operations = 1 + 2 + 3 + 4 + 5 = 15.
// For size n, this forms a triangular sum: n * (n + 1) / 2 -> O(n^2).
//
// 2. WITH THE (ele - 1) CHECK -> O(n)
// -------------------------------------------------------------------------
// The '!mapOfNums.containsKey(ele - 1)' condition acts as a strict gatekeeper. 
// It guarantees the inner 'while' loop ONLY executes if 'ele' is the 
// absolute starting point of a sequence.
//
// Let's trace the target array [6, 5, 4, 3, 2, 12, 11, 10, 9, 8]:
// - i = 0 (6): Is 5 in map? Yes -> Skip! (1 outer check)
// - i = 1 (5): Is 4 in map? Yes -> Skip! (1 outer check)
// - i = 2 (4): Is 3 in map? Yes -> Skip! (1 outer check)
// - i = 3 (3): Is 2 in map? Yes -> Skip! (1 outer check)
// - i = 4 (2): Is 1 in map? NO  -> Sequence Start Found!
//              Inner while loop processes: 2, 3, 4, 5, 6 (5 inner iterations)
// - i = 5 (12): Is 11 in map? Yes -> Skip! (1 outer check)
// - i = 6 (11): Is 10 in map? Yes -> Skip! (1 outer check)
// - i = 7 (10): Is 9 in map?  Yes -> Skip! (1 outer check)
// - i = 8 (9):  Is 8 in map?  Yes -> Skip! (1 outer check)
// - i = 9 (8):  Is 7 in map?  NO  -> Sequence Start Found!
//              Inner while loop processes: 8, 9, 10, 11, 12 (5 inner iterations)
//
// TALLYING THE WORK:
// - Outer loop checks: Done exactly once per element     = 10 ops
// - Inner loop visits: Processes each group sequence once = 5 + 5 = 10 ops
//
// Total Operations = 10 + 10 = 20 operations (Exactly 2n ops).
//
// Because every number is inspected at most twice—once in the outer loop 
// and at most once across all inner loops lifetime—the overall time 
// complexity drops beautifully to O(n).
//
// SPACE COMPLEXITY: O(n) 
// - The HashMap holds up to n elements to achieve O(1) lookups.
// =========================================================================
