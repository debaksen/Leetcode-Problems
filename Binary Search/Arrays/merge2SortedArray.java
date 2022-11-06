class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index = m+n-1;
        int bp1 = m-1;
        int bp2 = n-1; 
        
        while(bp1 >= 0 && bp2 >= 0){
            if(nums1[bp1] > nums2[bp2]){
                nums1[index] = nums1[bp1];
                bp1--;
            }
            
            else{
                nums1[index] = nums2[bp2];
                bp2--;
            }
            index--;
        }
        
        while(bp1 >= 0){nums1[index--] = nums1[bp1--];}
        while(bp2 >= 0){nums1[index--] = nums2[bp2--];}
        
    }
}