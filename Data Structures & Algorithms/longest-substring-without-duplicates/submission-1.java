class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;

        int n = s.length();
        HashSet<Character> hashSpace = new HashSet<>();

        int maxLength = 0;

        while(j<n && i<n){
            if(!hashSpace.contains(s.charAt(j))){
                hashSpace.add(s.charAt(j));
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            }
            else{
                hashSpace.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}
