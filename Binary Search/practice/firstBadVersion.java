/* 
https://leetcode.com/problems/first-bad-version/
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int start = 0;
        int firstBadNum = 0; 
        
        while(start <= n){
            int mid = start + (n - start)/2; 
            if(isBadVersion(mid)){
                firstBadNum = mid;
                n = mid-1; 
            }
            
            else start = mid+1; 
        }
        
        return firstBadNum; 
    }
}