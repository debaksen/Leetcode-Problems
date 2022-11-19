https://leetcode.com/problems/n-queens/submissions/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        String[][] chess = new String[n][n];
        List<List<String>> output = new ArrayList<List<String>>(); 
        
        for(String[] arr : chess){
            Arrays.fill(arr,"."); 
        }
        fillNQueen(chess,n,0, output);
        return output; 
    }
    
    public static void fillNQueen(String[][] chess, int n, int row,List<List<String>> output){

        if(row >= n){
            List<String> res = new ArrayList<String>();
            for(int i=0;i<n;i++){
            StringBuffer sb = new StringBuffer();
                for(int j=0;j<n;j++){
                    sb.append(chess[i][j]); 
                }
                res.add(sb.toString()); 
            }
            
            output.add(res); 
            return; 
        }
        
        for(int col = 0; col < n; col++){
            if(isPossibleQueen(chess, row , col,n)){
            chess[row][col] = "Q"; 
            fillNQueen(chess,n,row+1,output);
            chess[row][col] = ".";
            }
        }
    }
    
    public static Boolean isPossibleQueen(String[][] chess, int r, int c, int n){
        
        // row wise check
        for(int i = r, j = 0; j < n ; j++){
            if(chess[i][j] == "Q") return false;
        }
        
        // col wise check
        for(int j = c, i = 0; i<n;i++){
            if(chess[i][j] == "Q") return false;
        }
        
        
        // left diagonal wise check i-1, j-1
        for(int i=r,j = c; i>=0 && j >= 0; i--,j--){
            if(chess[i][j] == "Q") return false;  
        }

        // right diagonal wise check i-1, j+1
        for(int i=r,j = c; i>=0 && j < n; i--,j++){
            if(chess[i][j] == "Q") return false;  
        }
        return true; 
    }
}