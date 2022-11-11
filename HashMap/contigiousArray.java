https://leetcode.com/problems/contiguous-array/

class Solution {
    public int findMaxLength(int[] nums) {
        // mark 1 as +1 and 0 as -1 and create a sum array 
        int[] sumArr = new int[nums.length];
        int maxLen = 0; 
        int trackSum = 0;
        int index = 0;
        for(int ele : nums){
            trackSum += (ele != 0)? 1 : -1; 
            sumArr[index++] = trackSum; 
        }
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); 
        
        for(int idx = 0; idx <nums.length;idx++){
            int val = sumArr[idx]; 
            if(!map.containsKey(val)) map.put(val,idx); 
            else{
                int currSubArrLen = idx - map.get(val); 
                maxLen = Math.max(currSubArrLen,maxLen); 
            }
        }
        
        return maxLen; 
    }
}