package leetcode;

public class maze {
    public static int maze(int[][] grid){

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];// visited=1: 来的路，所以不dfs, visited=0; 不是来的路，dfs

        if(grid == null || rows == 0 || cols == 0) return 0;
        if(dfshelper(0,0,grid,visited)){
            return 1;
        }
        return 0;
    }

    public static boolean dfshelper(int i, int j, int[][] grid,int[][] visited){
        if(i>=0 && i< grid.length && j>=0 && j< grid[0].length && grid[i][j] == 9) {
            visited[i][j] = 1;
            return true;
        }
        if(i>=0 && i< grid.length && j>=0 && j< grid[0].length && grid[i][j] == 1 && visited[i][j] == 0){
            visited[i][j] = 1;

            if(dfshelper(i,j-1,grid,visited)) {return true;}
            if(dfshelper(i,j+1,grid,visited)) {return true;}
            if(dfshelper(i-1,j,grid,visited)) {return true;}
            if(dfshelper(i+1,j,grid,visited)) {return true;}
            else {
                visited[i][j] = 0;
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] grid = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 9, 1, 1, 1}};
        System.out.print(maze(grid));
    }
}
