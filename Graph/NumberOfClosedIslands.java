class Solution {
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int currRow = 0; currRow < m; currRow++){
            if(grid[currRow][0]  == 0) dfs(grid,currRow,0,m,n); 

            if(grid[currRow][n-1] ==  0)  dfs(grid,currRow,n-1,m,n);  
        }

        for(int currCol = 0; currCol < n; currCol++){
            if(grid[0][currCol] ==  0) dfs(grid,0,currCol,m,n);

            if(grid[m-1][currCol] == 0) dfs(grid,m-1,currCol,m,n);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0){
                    ans +=1;
                    dfs(grid,i,j,m,n); 
                }
            }
        }

        return ans;  
    }

    private void dfs(int[][] grid, int currRow, int currCol, int m, int n){
        if(currRow < 0 || currRow > m-1 || currCol < 0 || currCol > n-1 || grid[currRow][currCol] == 1) return;

        grid[currRow][currCol] = 1; 
        dfs(grid,currRow+1,currCol,m,n);
        dfs(grid,currRow-1,currCol,m,n);
        dfs(grid,currRow,currCol+1,m,n);
        dfs(grid,currRow,currCol-1,m,n);
        return; 
    }
}