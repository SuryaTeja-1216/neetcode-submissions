class Solution {
    public int longestConsecutive(int[] nums) {
        // optimal solution instead of using Hashmap use a HashSet 

        HashSet<Integer> setOfNums = new HashSet<>();

        for(int ele:nums){
            setOfNums.add(ele);
        }

        int longestConsecutiveSequence = 0;
        for(int key:setOfNums){
            if(!setOfNums.contains(key-1)){
                int length=1;
                while(setOfNums.contains(key+length)){
                    length++;
                }
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, length);
            }
        }

        return longestConsecutiveSequence;
    }
}

/*
yes I dont think we need the visited check the gatekeeper is soley enough, 
only for the duplicate start value we will traverse again. 
But its a hashset so the duplicates wont be present so no need to worry is what I think
*/


// time complexity
/*
O(n) to add the elements to set
O(n) for the traversal if there n distinct elements and not consecutive 
or O(2*n) if there is n length sequence for O(n) elements to find the first element of the sequence
O(n) for calculating the sequence 
*/

// space complexity
/*
O(n) for hashmap
*/