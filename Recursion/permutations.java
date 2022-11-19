class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        
        generatePermutations(nums,0,res);
        return res;
        
    }
    
    private static void generatePermutations(int[] nums, int idx, List<List<Integer>> res){
        
        if(idx >= nums.length){
            List<Integer> buffer = new ArrayList<>();
            for(int ele : nums){buffer.add(ele);} 
            res.add(buffer);
            return; 
        }
        
        for(int i=idx; i<nums.length;i++){
            swap(nums,i,idx);
            generatePermutations(nums,idx+1,res);
            swap(nums,i,idx); 
        }
    }
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}