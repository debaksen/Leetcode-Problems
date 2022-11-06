class Solution {
    public void sortColors(int[] nums) {
        
        int lo = 0;
        int mid = 0;
        int hi = nums.length-1; 
        
        while(mid <= hi){
         
            if(nums[mid] == 0){
                swap(nums,lo,mid);
                lo++;
                mid++;
            }
            
            else if(nums[mid] == 1){
                mid++;
            }
            
            else {
                swap(nums,mid,hi);
                hi--; 
            }
        }
        
    }
    
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp; 
    }
}