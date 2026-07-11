class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Optimal solution to reduce time complexity of sorting

        HashMap<String, List<String>> anagrams = new HashMap<>();

        // iterate through the given String
        for(String word: strs){

            int[] anagramCharArray = new int[26];

            for(int i=0;i<word.length();i++){
                anagramCharArray[word.charAt(i)-'a']++;
            }

            StringBuilder formattedWord = new StringBuilder();
            for(int i=0;i<26;i++){
                formattedWord.append(anagramCharArray[i]).append('*');
            }

            String convertedWord = formattedWord.toString();
            System.out.println(convertedWord);

            if(anagrams.containsKey(convertedWord)){
                List<String> anagramsPresent = anagrams.get(convertedWord);

                anagramsPresent.add(word);

                anagrams.put(convertedWord,anagramsPresent);
            }
            else{
                List<String> newAnagramList = new ArrayList<>();

                newAnagramList.add(word);

                anagrams.put(convertedWord,newAnagramList);
            }

        }

        Iterator<String> keyIterator = anagrams.keySet().iterator();

        List<List<String>> groupedAnagramResult = new ArrayList<>();
        while(keyIterator.hasNext()){
            String key = keyIterator.next();

            groupedAnagramResult.add(anagrams.get(key));
        }

        return groupedAnagramResult;
    }
}

/*
    time
    array traversal - O(n)
    word traversal - O(m)
    convertig array to string O(26)
    O(m) for contains in hashmap
    O(total anagram groups) 

    space
    HashMap O(n) for key
    list O(n*m)

    n*O(26) for char array 
    O(m) for formatted string 
*/


// DEFINITIONS:
// n = Number of strings in the input array (strs.length)
// m = Maximum length of an individual string

// ⏰ TIME COMPLEXITY: O(n * m)
// Inside the main loop (which runs n times):
// 1. Character Frequency Counting: Loops through the word's characters -> O(m)
// 2. Building the Key: Loops exactly 26 times -> O(1) constant time
// 3. HashMap Lookups (containsKey, get, put): The key length is fixed at ~52 characters 
//    (26 counts + 26 delimiters) regardless of how long the original word is. 
//    Therefore, computing the hash code drops to a fixed O(1) constant time.
//
// Total Main Loop Work: n * (O(m) + O(1) + O(1)) = O(n * m)
//
// Note on the final Iterator Loop: 
// The while loop iterates over the distinct anagram groups (at most n groups) and collects 
// the lists. This takes a cumulative O(n) time, which gets absorbed by the dominant O(n * m) phase.
//
// Overall Time Complexity = O(n * m)


// 💾 SPACE COMPLEXITY: O(n * m)
// 1. HashMap Storage:
//    - Keys: At most n unique keys. Each key is a fixed pattern string of length ~52. 
//      Space scales purely with the number of unique groups -> O(n)
//    - Values: The lists dynamically distribute and hold all original n strings. 
//      Since each string has a max length of m, total character storage across all lists 
//      is capped exactly at n * m -> O(n * m)
//
// 2. Auxiliary Loop Allocations:
//    - int[26] array, StringBuilder, and key strings take up a fixed O(1) space per 
//      iteration because their sizes are strictly bound by the alphabet size (26), not word lengths.
//
// 3. Output List: 
//    - The final result references the grouped arrays, consuming up to O(n * m) space.
//
// Overall Space Complexity = O(n) + O(n * m) -> O(n * m)