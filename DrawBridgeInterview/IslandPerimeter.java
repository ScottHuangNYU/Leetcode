package DrawBridgeInterview;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int areaOfIsland = 0, neighbor = 0;
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    areaOfIsland++;
                    if(i < m - 1 && grid[i + 1][j] == 1) neighbor++;
                    if(j < n - 1 && grid[i][j + 1] == 1) neighbor++;
                }
            }
        }
        return areaOfIsland * 4 - 2 * neighbor;
    }
}
