/*
https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
*/

static int findFloor(long arr[], int n, long x)
    {
        int floorIndex = -1; 
        
        int start = 0, end = arr.length-1; 
        
        while(start <= end){
            
            int mid = start + (end - start)/2; 
            if(arr[mid]  == x){
                floorIndex = mid; 
                break; 
            }
            else if(arr[mid] < x ){ 
                floorIndex = mid; 
                start = mid+1; 
            }
            else 
                end = mid -1; 
        }
        
        return floorIndex; 
    }