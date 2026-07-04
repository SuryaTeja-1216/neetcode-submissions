class Solution {
    public boolean isAnagram(String s, String t) {

        // convert them to character array, sort them and now check every element index by index if anything doesnt match return false
        int sLength = s.length();
        int tLength = t.length();

        if(sLength != tLength) return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // System.out.println(Arrays.toString(ch1));
        // System.out.println(Arrays.toString(ch2));

        // checking if any of the character doesnt match and returning false
        for(int i=0;i<sLength;i++){
            if(ch1[i]!=ch2[i]) return false;
        }

        return true;
    }
}

// Time complexity O(nlogn) + O(mlogm) + O(m)
// space complexity O(n) + O(m)