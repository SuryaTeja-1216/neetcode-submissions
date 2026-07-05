class Solution {
    public boolean isAnagram(String s, String t) {
        // two hashmaps and check the count 

        int n1 = s.length();
        int n2 = t.length();

        if(n1!=n2) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();

        HashMap<Character, Integer> map2 = new HashMap<>();


        // count of the both strings match, so iterate through strings and increase the counts in the hashmap
        for(int i=0;i<n1;i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);

            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }

        System.out.println(map1);
        System.out.println(map2);

        // iterate of one the string and check the counts for each element if the counts match return true else false
        for(int i=0;i<n1;i++){
            // here I am iterating complete s and checking if both the map has the same counts or not
            // using the equals if the value exceeds 127 
            if(!map1.get(s.charAt(i)).equals(map2.get(s.charAt(i)))) {
                System.out.println(i);
                System.out.println(s.charAt(i));
                System.out.println(map1.get(s.charAt(i)));
                System.out.println(map2.get(s.charAt(i)));
                return false;
            }
        }
        

        return true;
    }
}

/*
Java has a feature called Integer Cache. For the values between -128 and 127, Java automatically reuses the same memory objects.

If your anagrams were short (e.g., "racecar"), the counts were likely small (e.g., 1, 2, 3).

Since those numbers are cached, Java pointed both map1 and map2 to the same memory address for those values. Therefore, == happened to return true by accident.

However, once your character counts grew large (e.g., 1943), those numbers fell outside the cache range. So we have to use equals method 

*/
