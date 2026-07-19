class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();

        HashSet<List<Integer>> uniqueTriplets = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    ArrayList<Integer> temp = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]==0){
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if(!uniqueTriplets.contains(temp)){
                            resultList.add(temp);
                            uniqueTriplets.add(temp);
                        }
                    }
                }
            }
        }

        return resultList;
    }
}

//time complexity
/*
even though we are using the sorting it is only for a smaller set so the 
time complexity is O(n^3)
*/

// space complexity
/*
O(m) m uniqueTriplets 
*/

// =========================================================================
// COMPLEXITY ANALYSIS: 3Sum Brute Force with Triplet Sorting
// =========================================================================
//
// TIME COMPLEXITY: O(n^3)
// -------------------------------------------------------------------------
// 1. Three Nested Loops:
//    The code explores every possible combination of 3 unique indices (i, j, k).
//    The total number of combinations checked is exactly:
//    n * (n - 1) * (n - 2) / 6
//    As n grows massive, the dominant term is n^3. The constant divisor (1/6)
//    is dropped, leaving us with a tight bound of O(n^3).
//
// 2. Sorting Each Triplet (Collections.sort):
//    The 'temp' list ALWAYS contains exactly 3 elements. Sorting a fixed 
//    list of size 3 takes a maximum of 3 * log(3) ≈ 5 operations. Because 
//    this does NOT scale with the size of the input array 'n', it is considered
//    a constant-time operation -> O(1).
//
// 3. Set Operations (contains/add):
//    Hasing a list of 3 elements takes constant time -> O(1).
//
// Total Time Complexity = O(n^3) loops * O(1) inner work = O(n^3)
//
// -------------------------------------------------------------------------
// SPACE COMPLEXITY: O(m) where m is the number of UNIQUE triplets
// -------------------------------------------------------------------------
// 1. HashSet Storage:
//    The 'uniqueTriplets' HashSet stores lists of size 3. In the absolute 
//    worst-case scenario, the number of unique valid triplets (m) can scale 
//    quadratically relative to the input array size -> O(n^2).
//
// 2. Result Array List:
//    The final 'resultList' mirrors the unique triplets found in the set.
//
// Total Extra Space Complexity = O(m) or worst-case O(n^2) due to the HashSet.
// =========================================================================