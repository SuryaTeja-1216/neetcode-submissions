class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        int checker = nums[0];
        int count=1;

        ArrayList<Integer>[] sortedCountsArray = new ArrayList[n];

        for(int i=0;i<n;i++){
            sortedCountsArray[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<n;i++){
            if(nums[i]==checker){
                count++;
            }
            else{
                sortedCountsArray[count-1].add(checker);
                checker = nums[i];
                count=1;
            }
        }

        sortedCountsArray[count-1].add(checker);

        int[] result = new int[k];
        int j=0;

        for(int i=n-1;i>=0;i--){
            if(!sortedCountsArray[i].isEmpty()){
                for(int key:sortedCountsArray[i]){
                    if(j==k){
                        break;
                    }
                    else{
                        result[j++] = key;
                    }
                }
            }

            if(j==k) break;
        }

        return result;
    }
}

// time complexity
/*
O(nlogn) we are paying with the sorting -> but it should have reduced the space complexity 
this problem indeed uses the bucket sorting by doing a fancy sorting which is of no use here
space 
*/


/*
 * The "Double Penalty" Trap
 * -------------------------
 * 1. Arrays.sort(nums): 
 * The whole point of sorting is to avoid using extra memory space. It groups 
 * identical numbers together so you can count them sequentially, but it 
 * costs O(n log n) time.
 * * 2. ArrayList[] sortedCountsArray (Bucket Sort): 
 * The whole point of a Bucket Array is to avoid sorting! It gives you 
 * lightning-fast O(n) time, but it costs a massive O(n) extra memory space.
 * * By doing both, your solution takes O(n log n) time AND O(n) space. 
 * It is the worst of both worlds.
 */