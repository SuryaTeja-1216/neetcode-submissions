class Solution {
    public int[] twoSum(int[] nums, int target) {
        // optimal solution using a hashmap for every element find the difference with target 
        // first element 3 target 7, difference is 4 insert this into hashmap 
        // and now when you traverse to the next element check whether it is already present in the hashmap and if it exists return the index 
        // key will be diff and value will be the index 

        HashMap<Integer, Integer> targetDiff = new HashMap<>();

        int[] result = {-1,-1};

        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];

            if(targetDiff.containsKey(nums[i])){
                result[0] = targetDiff.get(nums[i]);
                result[1] = i;
            }
            else{
                targetDiff.put(diff, i);
            }
        }

        System.out.println(targetDiff);
        return result;
        
    }

}

// Time - O(n)
// Space - O(n)
