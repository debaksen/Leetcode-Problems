class Solution {
    public int mySqrt(int x) {
       
        long start = 0;
        long end = x;
        int sqrt = 0; 
        
        while(start <= end){
            long mid = start + (end - start)/2; 
            if(mid * mid == x) return (int)mid;
            
            else if(mid * mid > x){
                end = mid - 1; 
            }
            else {
                start = mid + 1; 
                sqrt = (int)mid; 
            }
        }
        
        return sqrt; 
        
    }
}