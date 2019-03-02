package leetcode;

public class Maze490 {
    private int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
    private int m;
    private int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        m = maze.length;
        n = maze[0].length;
        int[][] visited = new int[m][n];
        return dfsHelper(maze,start[0],start[1],destination[0],destination[1],visited);
    }

    private boolean dfsHelper(int[][] maze, int i, int j, int di, int dj, int[][] visited) {
        if(i >= 0 && i < m && j >= 0 && j < n && i == di && j == dj) return true;

        visited[i][j] = 1; // mark this point visited;

        boolean res = false;
        for(int[] d : dir){
            int si = i;
            int sj = j;
            while(si+d[0] >= 0 && si+d[0] < m && sj+d[1] >= 0 && sj+d[1] < n && maze[si+d[0]][sj+d[1]] == 0){
                si += d[0];
                sj += d[1];
            }
            if(visited[si][sj] == 0 ){
                res = res || dfsHelper(maze,si,sj,di,dj,visited);
            }
        }
        return res;
    }


}



