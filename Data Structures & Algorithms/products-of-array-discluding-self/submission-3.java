class Solution {
    public int[] productExceptSelf(int[] nums) {
        // caluculate the total product of the nums and then use it 
        // to fill every element product

        int productOfAllElements = 1;

        int countOfZeros = 0;

        boolean zeroPresent=false;
        for(int ele:nums){
            if(ele!=0)
            productOfAllElements*=ele;
            else {
                countOfZeros++;
                zeroPresent=true;
            }
        }


        int n = nums.length;

        int[] result = new int[n];

        if(countOfZeros>1) return result;

        for(int i=0;i<n;i++){
            if(zeroPresent && nums[i]==0)
            result[i] = productOfAllElements;
            else if(zeroPresent && nums[i]!=0)
            result[i]=0;
            else 
            result[i] = productOfAllElements/nums[i];
        }

        return result;
    }
}  

// only possible cases could be
/*
there is 0 prsent in the nums and 0 not present 
0 is present 
    for every element the product is zero
    for the zero element the product is product of all elements except zero
0 is not present 
    for every element we divide the total product with the current element
*/


// failure test case when the number of zeros is more than 1 
/*
nums=[-1,0,0,2,3]

this code output - [0,-6,-6,0,0]

expected output  - [0,0,0,0,0]

this happens when the count of zeros > 1, if the count > 1 return all array with all 0's
*/


// time complexity - O(n)

// space complexity - O(1)