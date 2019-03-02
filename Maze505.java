package leetcode;

public class Maze505 {
    private int m;
    private int n;
    private int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int[][] dis = new int[m][n];
        dis[start[0]][start[1]] = 1;
        dfs(maze, start[0], start[1], destination[0], destination[1], dis);
        return dis[destination[0]][destination[1]] - 1;
    }

    private void dfs(int[][] maze, int si, int sj, int di, int dj, int[][] dis) {

        if (si >= 0 && si < m && sj >= 0 && sj < n && si == di && sj == dj) return;

        for (int[] d : dir) {
            int i = si;
            int j = sj;
            int count = dis[si][sj];
            while (i + d[0] >= 0 && i + d[0] < m && j + d[1] >= 0 && j + d[1] < n && maze[i + d[0]][j + d[1]] == 0) {
                i += d[0];
                j += d[1];
                count++;
            }
            if (dis[i][j] > 0 && count >= dis[i][j]) {
                continue;
            }
            dis[i][j] = count;
            dfs(maze, i, j, di, dj, dis);
        }
    }


}
