class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;

        HashSet<Character> uniqueSpace = new HashSet<>();

        int n = s.length();
        int maxLength = 0;

        while(j<n){
            if(!uniqueSpace.contains(s.charAt(j))){
                maxLength = Math.max(maxLength, j-i+1);
                uniqueSpace.add(s.charAt(j));
                j++;
            }
            else{
                uniqueSpace.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}


// here we are checking whether the element at j is in the hashset or not and remove i 

// dvdf when j=2 and i=0 hashset will [d,v]
// j is already present we remove element at i and move it 
// dvdf i=1 and j= 2 where i is pointing v and j is pointing to d hashset has [v] we are checking the element at j whether it is present in the set or not 
// since d is not present we increase the count and update the hashset because vdf is a valid substring 