class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele:nums){
            map.put(ele, map.getOrDefault(ele,0)+1);

            if(map.get(ele)>1) return true; 
        }

        return false;

    }
}