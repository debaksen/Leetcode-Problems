// GFG - Allocate minimum number of pages (Hard)

//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int result  = -1; 
        int start = 0;
        int end = findSum(A); 
        
        // if no. of book < no. of students return false
        if(A.length < M) return -1;
        
        while(start <= end){
            int mid = start + (end - start)/2; 
            if(isPossible(mid,A,N,M)){
                result = mid;
                end = mid - 1; 
            }
            else {
            start = mid+1;
            }
        }
        return result; 
    }
    
    private static Boolean isPossible(int max, int[] pages, int totBook, int totStudent){
        
        int currSum = 0;
        int currStudentCnt = 1;
        for(int currBookPage : pages){
            
            if(currBookPage > max){
            return false;
            }
            
            if(currSum + currBookPage <= max){
                currSum += currBookPage;
            }
            else {
                currStudentCnt +=1; 
                currSum = currBookPage;
                
                if(currStudentCnt > totStudent){
                return false;
                }
            }
        }
        
        return true; 
    }
    
    private static int findSum(int[] A){
        int res = 0;
        for(int num : A){
            res+=num;
        }
        
        return res; 
    }
    
};