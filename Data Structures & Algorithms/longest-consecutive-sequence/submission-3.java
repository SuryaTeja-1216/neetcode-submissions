class Solution {
    public int longestConsecutive(int[] nums) {
        // sort the arrays and count the length 

        Arrays.sort(nums);

        int longestConsecutiveSequence = 0;
        int n = nums.length;

        if(n==0) return 0;
        int length=1;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]==1){
                // System.out.println("in loop");
                length++;
            }
            else if(nums[i+1]-nums[i]!=0){
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, length);
                length=1;
            }
        }
        longestConsecutiveSequence = Math.max(longestConsecutiveSequence, length);
        return longestConsecutiveSequence;
    }
}

// time complexity 
/*
sorting o(nlogn)
O(n) for counting the sequence
*/

// space complexity 
/*
constant space O(1)
*/
