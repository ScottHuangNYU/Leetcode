package DrawBridgeInterview;

public class LargestSumInARow {
    public int LargesrSum(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int n = grid.length, m = grid[0].length;

        int i =0, j = 0,row = 0;

        while(i < n && j < m){
            while(i < n && j < m && grid[i][j] == 1){
                j++;
                row = i;
            }
            while(i < n && j < m && grid[i][j] == 0){
                i++;
            }
        }
        return j;
    }

    public static void main(String[] args){
        int[][] a = {{1,0,0,0,0},{1,1,1,0,0},{1,1,0,0,0}};
        LargestSumInARow b = new LargestSumInARow();
        System.out.println(b.LargesrSum(a));
    }
}
