package DrawBridgeInterview;

public class NumberOfIsland {
    private int count;
    private int m,n;
    public int numsOfIsland(int[][] grid){
        if(grid == null || grid.length == 0) return 0;

        count = 0;
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return;

        grid[i][j] = 0;

        dfs(grid,i - 1, j);
        dfs(grid, i , j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }


}
