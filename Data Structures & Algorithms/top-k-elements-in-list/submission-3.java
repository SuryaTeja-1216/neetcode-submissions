class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap to store the frequency of the array elements

        HashMap<Integer,Integer> freqOfElements = new HashMap<>();

        for(int ele:nums){
            freqOfElements.put(ele, freqOfElements.getOrDefault(ele, 0)+1);
        }

        // put the key - ele value - frequency into a array list that store the array as elements so we can sort them based on their frequency 
        ArrayList<int[]> listOfElementAndFrequencies = new ArrayList<>();


        // put the key value pairs into the list by adding them into arrays
        for(Map.Entry<Integer, Integer> keySet: freqOfElements.entrySet()){
            listOfElementAndFrequencies.add(new int[] {keySet.getValue(), keySet.getKey()});
        }

        // sort the list based on the frequency of elements using the lambda function 

        // which stores the values like for array [4,5,5,6,6,6] <[1,4], [2,5], [3,6]> 

        listOfElementAndFrequencies.sort((a,b) -> b[0]-a[0]);


        // after sorting it becomes <[3,6],[2,5],[1,4]> 
        int[] result = new int[k];

        // now iterate for k and fetch the elements and add them to the result 

        for(int i=0;i<k;i++){
            result[i] = listOfElementAndFrequencies.get(i)[1];
        }

        // if the array is [1,2] the listOfElementAndFrequencies will be like <[1,1],[1,2]>
        // even if the frequency is same for the both elements we have separate for each and we dont need them in any order for the result
        // we can return them by iterating through k times and adding them to the result

        return result;

    }
}

// time complexity 
/*
O(n) for hashmap

insert the element in the arraylist O(n)

sort the elements if there are n distinct elements then O(nlogn) 

O(k) for putting back to the result 
*/


// space
/*
O(n) for hashmap
O(n) for freq arraylist

*/

/*
### Complexity Analysis

* Time Complexity: O(n log n) in the worst case
    - O(n) to iterate through the nums array and build the frequency map.
    - O(m) to transfer the unique key-value pairs into the ArrayList, where m is the number of unique elements (m <= n).
    - O(m log m) to sort the array list using the lambda comparator. In the worst-case scenario where all elements in the input array are unique (m = n), this becomes O(n log n).
    - O(k) to iterate k times and populate the final result array.
    - Total Time: O(n + m log m + k) -> O(n log n) worst-case.

* Space Complexity: O(n)
    - O(m) auxiliary space for the HashMap to store unique element-frequency pairings.
    - O(m) auxiliary space for the listOfElementAndFrequencies array list to hold the pairs.
    - Total Auxiliary Space: O(m) -> O(n) worst-case when all elements are unique.
*/
