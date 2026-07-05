class Solution {
    public boolean isAnagram(String s, String t) {
        // using a single HashMap increasing the count for one string and decrease the counts usig the second string
        // after this check the counts of each key if any count != 0 return false;

        int lengthOfS = s.length();
        int lengthOfT = t.length();
        if(lengthOfS!=lengthOfT) return false;
        HashMap<Character, Integer> countOfElements = new HashMap<>();

        for(int i=0;i<lengthOfS;i++){
            countOfElements.put(s.charAt(i), countOfElements.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<lengthOfT;i++){
            countOfElements.put(t.charAt(i), countOfElements.getOrDefault(t.charAt(i),0)-1);
        }

        // for(int i=0;i<lengthOfS;i++){
        //     if(countOfElements.get(s.charAt(i))!=0) return false;
        // }


        for(Map.Entry<Character, Integer> entries:countOfElements.entrySet()){
            if(entries.getValue()!=0) return false ;
        }
        return true;
    }
}
