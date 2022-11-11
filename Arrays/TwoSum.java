class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int elem = 0; elem < nums.length; elem++){
            
            if(elem > 0){
                if(map.containsKey(target - nums[elem])){
                    int[] res = new int[]{map.get(target - nums[elem]),elem};
                    return res;
                    
                }
            }
            map.put(nums[elem],elem); 
        }
        
        return new int[]{-1,-1};
        
    }
}