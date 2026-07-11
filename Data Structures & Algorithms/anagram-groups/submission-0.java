class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // brute sort the string and put the sorted value as a key in the hashmap
        // why key and sorting, two words are anagrams if they have the same number of characters present 
        // simpliest way to find the same number of characters is to sort the string 
        // [act, cat] are anagrams because counts of the characters are same if we sort them act -> act and cat -> act
        // Iterate through the given input of strings, and sort them here the sorted value is required for the lookup
        // the common thing between act and cat is the sorted value and if we use them as key we can group the anagrams
        // for act sorted value act. HashMap has act as key and when we iterate to the cat the sorted value is act which is present in the hashmap so we group them 

        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String word: strs){
            // convert the word to char array to sort the string
            char[] wordArray = word.toCharArray();

            Arrays.sort(wordArray);

            String sortedWord = String.valueOf(wordArray);

            if(anagrams.containsKey(sortedWord)){
                List<String> anagramPresent = anagrams.get(sortedWord);

                anagramPresent.add(word);

                anagrams.put(sortedWord, anagramPresent);
            }
            else{
                List<String> newAnagram = new ArrayList<>();
                newAnagram.add(word);

                anagrams.put(sortedWord, newAnagram);
            }
        }

        List<List<String>> resultGroupAnagrams = new ArrayList<>();

        for(String anagramsGrouped: anagrams.keySet()){  

            resultGroupAnagrams.add(anagrams.get(anagramsGrouped));

        }
        
        return resultGroupAnagrams;

    }
}

// time complexity 
/*
n - size of the array, m length of the string

O(n) to traverse through the array
O(n*mlogm) to sort each word of the array
O(n) adding the group to result
*/

// space complexity 
/* 
we are putting list inside the hashmap not sure
O(n)

*/

/*
time -
O(n*mlogm)

O(n) for traversing through the array
O(m) converting the string to array
O(mlogm) for sorting the array
O(m) for hashmap get, put because the map needs to read the $m$-character string to compute its hash code.
we are using string.valueOf() which crates a new string
Java strings do cache their hash code once calculated. However, because you are creating a brand new String (String.valueOf(wordArray)) on every single iteration of your loop, its cached hash value is initially 0, forcing Java to recalculate it from scratch every time you call containsKey, get, or put
and it needs to iterate through the entire string of m characters 



inside loop O(n*mlogm) is most expensive Since we repeat this sorting process for all $n$ words in the array, we multiply them together


space - 
You guessed O(n) (or) O(m) using our variable definitions), which is on the right track, but we also have to account for the length of the strings stored inside that map.The HashMap Storage: 
* In the absolute worst case (where there are no anagrams at all), the anagrams map will hold $m$ unique keys.Each key is a sorted version of a string, which takes up to n space.
The values are lists that, combined, hold all original $m$ strings of length up to n.The Result List: Storing the final groups takes another O(m*n) space to reference or copy the output structure.Thus, the total auxiliary memory allocated scales with both the number of words and the size of those words:
*/
