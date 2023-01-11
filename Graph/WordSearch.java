https://leetcode.com/problems/word-search/description/

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length; 

        for(int currRow = 0; currRow < m; currRow++){
            for(int currCol = 0; currCol < n; currCol++){

                if(board[currRow][currCol] == word.charAt(0) && dfs(board,currRow, currCol,0,word,m,n)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int currRow, int currCol, int index, String word, int m, int n){
        if(index  >= word.length()) return true; 

        if(currRow < 0 || currRow >= board.length || currCol < 0 || currCol >= board[0].length || board[currRow][currCol] != word.charAt(index) ) return false;

        board[currRow][currCol] = '.';
         

        boolean found  = dfs(board,currRow-1,currCol,index+1,word,m,n) 
                        || dfs(board,currRow+1,currCol,index+1,word,m,n) 
                        || dfs(board,currRow,currCol-1,index+1,word,m,n) 
                        || dfs(board,currRow,currCol+1,index+1,word,m,n);

        board[currRow][currCol] = word.charAt(index);

        return found; 
    }

}