https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); 
        
        int sum[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i == 0) sum[i] = nums[i]; 
            
            else sum[i] = sum[i-1] + nums[i]; 
        }
        
        System.out.println(Arrays.toString(sum)); 
        
        for(int i=0;i<sum.length;i++){
            if(map.containsKey(sum[i] - k)){
                int freq = map.get(sum[i]-k);
                count+= freq; 
            } 
            
            map.put(sum[i],map.getOrDefault(sum[i],0)+1); 
        }
        
        return count; 
     
    }
}