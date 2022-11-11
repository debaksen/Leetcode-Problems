class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int windowStart = 0;
        int minSize = Integer.MAX_VALUE;
        int windowSum = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd ++){
            
            if(windowSum < target){
                windowSum += nums[windowEnd];
            }
            while(windowSum >= target){
            minSize = Math.min(minSize, (windowEnd-windowStart+1)); 
            windowSum -= nums[windowStart++];
            }
        }
        return (minSize == Integer.MAX_VALUE) ? 0 : minSize; 
    }
}