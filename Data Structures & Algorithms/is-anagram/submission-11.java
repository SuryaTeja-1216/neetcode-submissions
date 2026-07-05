class Solution {
    public boolean isAnagram(String s, String t) {
        // most optimal is take an array of 26 length because the alphabets (lower case mentioned ) in the problem is only 26

        if(s.length()!=t.length()) return false;
        int[] countOfCharacters = new int[26];

        for(int i=0;i<s.length();i++){
            countOfCharacters[s.charAt(i)-'a']++;
            countOfCharacters[t.charAt(i)-'a']--;
        }

        for(int i=0;i<s.length();i++){
            if(countOfCharacters[s.charAt(i)-'a']!=0) return false;
        }

        return true;
    }
}
