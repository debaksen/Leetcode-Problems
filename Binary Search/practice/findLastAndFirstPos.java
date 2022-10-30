/* 
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ 
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1}; 
        if(nums.length < 1) return res; 
        res[0] = findFirstIndex(nums,target);
        if(res[0] == -1) return res; 
        res[1] = findLastIndex(nums,target); 
        
        return res; 
    }
    
    private int findFirstIndex(int[] nums, int target){
        int  start = 0, end = nums.length-1; 
        int  firstIdx = -1; 
        
        while(start <= end){
            int mid = start + (end - start)/2; 
            
            if(nums[mid] == target){
                
                firstIdx = mid; 
                end = mid-1; 
            } 
            
            else if(nums[mid] > target) end = mid -1; 
            
            else start = mid+1;
        }
        return firstIdx; 
    }
    
    private int findLastIndex(int[] nums, int target){
        int start = 0, end = nums.length-1; 
        int lastIdx = -1; 
        
        while(start <= end){
            
         int mid = start + (end - start)/2; 
            
            if(nums[mid] == target){
                
                lastIdx= mid; 
                start = mid+1; 
            } 
            
            else if(nums[mid] > target) end = mid -1; 
            
            else start = mid+1;
        }
        return lastIdx; 
    }
}