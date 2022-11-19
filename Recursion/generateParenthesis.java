class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        callParenthesis(n,0,0,sb,res);
        return res;
    }
    
    private static void callParenthesis(int n, int opn, int close, StringBuffer sb, List<String> res){
        
        if(opn  == n && close == n){
            res.add(sb.toString());
            return; 
        }
        
        if(opn > n || close > n){
            return; 
        }
        
        if(opn < n){
            sb.append('('); 
            callParenthesis(n,opn+1, close, sb,res);
            sb.deleteCharAt(sb.length()-1);  
        }
        
        if(close < opn){
            sb.append(')');
            callParenthesis(n,opn,close+1, sb, res); 
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    
    
}