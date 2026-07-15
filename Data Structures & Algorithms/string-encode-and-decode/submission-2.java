class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded_string = new StringBuilder();

        for(String str:strs){
            encoded_string.append(str.length()).append('#').append(str);
            // encoded_string.append(str);
        }

        System.out.println(encoded_string);
        
        return encoded_string.toString();
    }

    public List<String> decode(String str) {

        List<String> decodedString = new ArrayList<>();
        int i=0;
        while(i<str.length()){

            int start=i;
            while(Character.isDigit(str.charAt(start)) && i<str.length()){
                start++;
            }

            int wordLength = Integer.parseInt(str.substring(i, start));

            // start is pointing to the special character # now so we move it one step further
            start++;
            int end = start+wordLength;
            decodedString.add(str.substring(start,end));

            i=end;
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


// Replaced the 'for' loop with a 'while' loop to gain manual control over the index without fighting automatic increments.

// Replaced the character-by-character extraction with Java's built-in '.substring()' for cleaner and heavily optimized word retrieval.

// Chained the '.append()' method calls together in the encode method instead of using the '+' operator for string concatenation.

// Chaining '.append()' prevents Java from creating temporary hidden string objects, avoiding garbage collection spikes that could degrade performance in high-scale backend systems.