
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    long count = 0; 
     long inversionCount(long arr[], long N)
    {
     mergeSort(arr,0,N-1); 
     return count;
    }
    
    private long[] mergeSort(long[] arr, long low, long high){
        
        if(low == high){
            long[] buffer = new long[1];
            buffer[0] = arr[(int)low];
            return buffer; 
        }
        
        long mid = (high+low)/2;
        long[] left=  mergeSort(arr,low,mid);
        long[] right = mergeSort(arr,mid+1,high);
        
        return mergeArrays(left, right,mid-low+1, high-mid);
        
    }
    
    private long[] mergeArrays(long[] left, long[] right, long n, long m){
        int i = 0;
        int j = 0;
        int k = 0;
        
        long[] res = new long[(int)(n+m+1)];
        
        while(i < n && j < m){
            if(left[i] <= right[j]){
                res[k++] = left[i++];
            }
            else{
                res[k++] = right[j++];
                count += n-i; 
            }
        }
        
        while(i<n){
            res[k++] = left[i++];
        }
        
        while(j<m){
            res[k++] = right[j++];
        }
        
        return res; 
    }
}