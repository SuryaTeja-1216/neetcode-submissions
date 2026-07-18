class Solution {
    public boolean isPalindrome(String s) {
        // using 2 pointers 

        int i=0;
        int j = s.length()-1;

        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(j>=0 && !Character.isLetterOrDigit(s.charAt(j))) j--;

            
            if(i<j && Character.toLowerCase(s.charAt(i))!= Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }

        return true;
    }
}

// time complexity 
/*
O(n) for the traversal 
*/

//space complexity 
/*
O(1)
*/