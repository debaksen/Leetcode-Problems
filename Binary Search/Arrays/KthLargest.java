class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(nums,0,nums.length-1,k-1);
        
    }
    
    public int quickSelect(int[] arr, int lo,int hi, int k){
        
        int pivot = partition(arr,lo,hi,arr[hi]); 
        
        if(k > pivot){
           return quickSelect(arr,pivot+1,hi,k); 
        }
        else if(k < pivot){
            return quickSelect(arr,lo,pivot-1,k);
        }
        else  return arr[pivot]; 
    }
    
    public int partition(int[] arr, int lo, int hi, int pivot){
        int i=lo, j = lo; 
        
        while(i <= hi){
            if(arr[i] >= pivot ){
                swap(arr,i,j); 
                i++; 
                j++;
            }
            else {
                i++; 
            }
        }
        return j-1; 
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}