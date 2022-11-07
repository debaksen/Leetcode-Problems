class Solution {
    public int maxProfit(int[] prices) {
        
        int lsf = Integer.MAX_VALUE;
        int maxProfit  = 0; 
        
        for(int i=0;i<prices.length;i++){
            if(prices[i] < lsf) lsf = prices[i];
            
            int currProfit = prices[i] - lsf;
            if(currProfit > maxProfit) maxProfit = currProfit; 
        }
        
        return maxProfit; 
      
    }
}