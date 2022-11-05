// Painter's Partition Problem
// https://www.interviewbit.com/problems/painters-partition-problem/


public class Solution {
    public long paint(int A, int B, int[] C) {
        
        long start = 0; 
        long ans = -1;
        long end = boardSum(C);
        
        while(start <= end){
            long mid = start + (end-start)/2; 
            if(isPossible(C,mid,A)){
                ans = mid;
                end = mid -1;
            }
            else {
                start = mid + 1; 
            }
        }
        
        return (ans % 10000003 * B % 10000003) % 10000003; 
    }
    
    private Boolean isPossible(int[] boards, long bound, long totalPainter){
        long currentPainter = 1; 
        long currentSum = 0; 
        
        for(long currBoard : boards){

            if(currBoard > bound){
                return false; 
            }
            if(currBoard + currentSum <= bound){
                currentSum += currBoard; 
            }
            else {
                currentPainter +=1; 
                currentSum = currBoard;
                
                if(currentPainter > totalPainter)
                return false; 
            }
        }
        return true; 
    }
    
    private long boardSum(int[] arr){
        long sum = 0;
        for(int curr : arr ){
            sum += curr ; 
        }
        return sum % 10000003;
    }
}


