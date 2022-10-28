class Solution {
    
    // MergeSort O(NlogN)
    public int[] sortArray(int[] nums) {
        
        int lo = 0; 
        int hi = nums.length-1; 
        mergeSort(nums,lo,hi); 
        return nums; 
    }
    
  
    public static void mergeSort(int[] arr, int lo, int hi){
        
        if(lo == hi) return; 
        
        int mid = lo + (hi-lo)/2; 
        mergeSort(arr,lo,mid); 
        mergeSort(arr,mid+1,hi);
        
        mergeSortedList(arr,lo,mid,hi);
        
    }
    
    public static void mergeSortedList(int[] arr, int lo, int mid, int hi){
        
        int len1 = mid-lo+1; 
        int len2 = hi - mid; 
        
        int[] subArr1 = new int[len1]; 
        int[] subArr2 = new int[len2];
        
        for(int i=0;i<len1;i++){
            subArr1[i] = arr[lo+i]; 
        }
         
        for(int j=0; j<len2;j++){
            subArr2[j] = arr[mid+1+j];
        }
        
        int i = 0, j=0, k=lo; 
        
        while(i < len1 && j < len2){
            if(subArr1[i] <= subArr2[j]){
                arr[k] = subArr1[i];
                i++; 
            }
            
            else{
                arr[k] = subArr2[j];
                j++;
            }
            k++; 
        }
        
        while(i < len1){
            arr[k] = subArr1[i];
            i++;
            k++; 
        }
        
        while(j<len2){
            arr[k] = subArr2[j];
            j++;
            k++;
        }
    }
}
    