class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Count all the element occurances in a hashmap 
        // 5,4,4,6,6,6 , k=2
        // {4=1,5=2, 6=3} is the result, we have to place in descendnig order 
        //based on their count of occurances [6,4,5] and top k elements are 6,4 so we return them
        // inorder to sort the elements based on their counts we can use of array of n size
        // max count of occurance for an element is n [5,5,5,5] n = 4 and 5 occurs 4 times
        // [0,0,0,5] sorted on the basis of occurance now we traverse from the back sorted occurance and check if the element is present in the counts hashmap or not 
        // update the result array and return the result

        HashMap<Integer, Integer> freqOfElements = new HashMap<>();

        for(int ele:nums){
            freqOfElements.put(ele, freqOfElements.getOrDefault(ele,0)+1);
        }

        int n = nums.length;

        ArrayList<Integer>[] countElementsBucket = new ArrayList[n];

        for(int i=0;i<n;i++){
            countElementsBucket[i] = new ArrayList<Integer>();
        }

        System.out.println(freqOfElements);

        for(Map.Entry<Integer, Integer> key: freqOfElements.entrySet()){
            countElementsBucket[key.getValue()-1].add(key.getKey());
        }

        // System.out.println(Arrays.toString(countElementsBucket));
        int[] result = new int[k];

        int j=0;

        for(int i=n-1;i>=0;i--){
            if(!countElementsBucket[i].isEmpty()){
                for(int ele:countElementsBucket[i]){
                    if(j==k) break;
                    else{
                        result[j] = ele;
                        j++;
                    }
                }

                if(j==k) break;
            }
        }

        return result;
    }
}

// time complexity
/*
O(n) to count the frequency of nums
O(n) to intialize the array of arraylists
sort the elements of the basis of their count is O(n)
to k put the elements to result 
 - best k = 1 and nums[5,5,5,5,5], the sorted array looks like arraylist [<>,<>,<>,<>,<5>]
 now we iterate from the back of array and see arraylist is not empty so we iterate thorugh the list and return the elment - O(1)
 -worst if all there are n distinct elements [6,7,8,9,10], the sorted arrayList looks like [<6,7,8,9,10>,<>,<>,<>,<>]
 [<6,7,8,9,10>,<>,<>,<>,<>] we iterate from the back see the arraylist at 4,3,2,1 which is empty we skip them and only for 0 we iterate throuh the arraylist 
which is ideally O(n)

i think O(n)+O(n)+O(n)+O(n)
*/

// space complexity
/*
hashmap - O(n)
array of arraylist  - not sure if it is O(n) in the best case we store only one arralist and in the worst we store all elements at one index

i think O(n)+O(n)
*/


// --- TIME AND SPACE COMPLEXITY ANALYSIS ---

// DEFINITIONS:
// n = Total number of elements in the nums array
// k = The number of top frequent elements to return

// ⏰ TIME COMPLEXITY: O(n)
// 1. Counting Frequencies: Iterating through nums to build the HashMap -> O(n)
// 2. Initializing Buckets: Creating the array of ArrayLists of size n -> O(n)
// 3. Populating Buckets: Iterating through the HashMap entries (max n entries) 
//    and adding them to the respective bucket -> O(n)
// 4. Extracting Top K: The outer loop iterates n times backwards. The inner 
//    loop only extracts a total of k elements across all buckets before breaking. 
//    This phase takes O(n + k) time. Since k <= n, this simplifies to O(n).
//
// Total Time Complexity = O(n) + O(n) + O(n) + O(n) -> O(n)


// 💾 SPACE COMPLEXITY: O(n)
// 1. HashMap (freqOfElements): Stores up to n unique elements and their counts -> O(n)
// 2. Bucket Array (countElementsBucket): The array itself takes up n slots -> O(n)
// 3. Bucket Contents: Across all the ArrayLists inside the bucket array, we store 
//    exactly the unique elements from the map. The total number of items stored 
//    inside these lists combined will never exceed n -> O(n)
// 4. Result Array: Stores exactly k elements -> O(k)
//
// Total Space Complexity = O(n) + O(n) + O(k) -> O(n)