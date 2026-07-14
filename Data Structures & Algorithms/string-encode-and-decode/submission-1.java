class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded_string = new StringBuilder();

        for(String str:strs){
            encoded_string.append(str.length()+"#");
            encoded_string.append(str);
        }

        System.out.println(encoded_string);
        
        return encoded_string.toString();
    }

    public List<String> decode(String str) {

        List<String> decodedString = new ArrayList<>();
        for(int i=0;i<str.length();i++){

            int start=i;
            while(Character.isDigit(str.charAt(start)) && i<str.length()){
                start++;
            }

            int wordLength = Integer.parseInt(str.substring(i, start));

            i=start+1;
            int end = i+wordLength;
            
            StringBuilder sb = new StringBuilder();
            while(i<end){
                sb.append(str.charAt(i));
                i++;
            }

            decodedString.add(sb.toString());
            i--;
        }

        return decodedString;
    }
}

// time complexity
/*
encode - iterate through the size of the list, n is the size of the list 
O(n)

for the input ["Hello","World"]
encode takes O(2)

decode - iterate through the sum of all the lengths of the string m 

for the input ["Hello","World"]
decode takes O(10)
*/
