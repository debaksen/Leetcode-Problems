class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length == 0) return res;
        List<Integer> sList = new ArrayList<>();

        getCombination(candidates,target,0,res,sList);
        return res;
    }
    
    private static void getCombination(int[] candidates, int target, int idx, List<List<Integer>> res, List<Integer> comb){
        
        if(target == 0){
            res.add(new ArrayList<>(comb)); 
            return; 
        }
        
        if(idx == candidates.length){
            return; 
        }
        
        if(candidates[idx] <= target){
        comb.add(candidates[idx]);
        getCombination(candidates,target - candidates[idx],idx,res,comb);
        comb.remove(comb.size()-1);
        }
        getCombination(candidates,target,idx+1,res,comb);
    
    }
}