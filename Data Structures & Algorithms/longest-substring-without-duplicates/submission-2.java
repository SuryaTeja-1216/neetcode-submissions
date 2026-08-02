class Solution {
    // using hashset
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n = s.length();

        HashSet<Character> uniqueSpace = new HashSet<>();

        int maxLength = 0;
        while(j<n){
            if(uniqueSpace.contains(s.charAt(j))){
                uniqueSpace.remove(s.charAt(i));
                i++;
            }
            else{
                uniqueSpace.add(s.charAt(j));
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            }
        }

        return maxLength;
    }
}

// time complexity
/*
O(n)
*/

// space complexiy
/*
total unique elements is k then O(k)
*/


/*
 * WHY WE SHRINK THE LEFT WINDOW (i) INSTEAD OF THE RIGHT (j):
 * 
 * Let's use the test case "zxyz":
 * - j=0 ('z'), window="z", set={'z'}
 * - j=1 ('x'), window="zx", set={'z','x'}
 * - j=2 ('y'), window="zxy", set={'z','x','y'}
 * - j=3 ('z'): Duplicate found! The set already contains 'z'.
 * 
 * If we move the right pointer (j) forward, we are just adding more 
 * characters to a window that is already invalid. The problem is the 
 * old 'z' that is currently inside our window.
 * 
 * To fix the window and make it valid (duplicate-free) again, we MUST 
 * shrink it from the left by moving 'i' forward. We keep removing 
 * characters at 'i' from our set until the duplicate character ('z') 
 * is completely kicked out of our current window. 
 * 
 * Once the old 'z' is removed (i moves past it), the window is valid 
 * again, and we can safely add the new 'z' (at j) and continue expanding.
 */