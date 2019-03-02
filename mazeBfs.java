package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class mazeBfs {
    public static int mazebfs(int[][] grid){
        if(grid == null) return 0;
        //四周的四个点
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<int[]>();
        int[] start = {0,0};
        queue.offer(start);
        int[][] visited = new int[rows][cols];
        while(!queue.isEmpty()){
            int[] point = queue.poll();

            visited[point[0]][point[1]] = 1;
            if(grid[point[0]][point[1]] == 9){
                return 1;
            }else if(grid[point[0]][point[1]] == 0){
                continue;
            }else {
                for(int i = 0; i<4; i++){
                    if(point[0]+dx[i] >= 0 && point[0]+dx[i] < rows && point[1]+dy[i] >=0 & point[1]+dy[i]< cols){
                        if(visited[point[0]+dx[i]][point[1]+dy[i]] == 0){
                            int[] next = {point[0]+dx[i],point[1]+dy[i]};
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[][] grid = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 9, 1, 1, 1}};
        System.out.print(mazebfs(grid));
    }
}
