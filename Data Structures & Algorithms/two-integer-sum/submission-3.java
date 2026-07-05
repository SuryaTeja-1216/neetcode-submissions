class Solution {
    public int[] twoSum(int[] nums, int target) {
        // using brute force pick an element at i and check any element from i+1 sum matches target and return index of both elements

        int n = nums.length;

        int[] result = {-1,-1};

        for(int i=0;i<n;i++){
            int sum = target-nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]==sum){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }

            if(result[0]!=-1 || result[1]!=-1) break;
        }

        return result;
    }
}

// time complexity O(n^2)