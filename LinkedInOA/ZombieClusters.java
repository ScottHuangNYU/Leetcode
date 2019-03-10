package LinkedInOA;

public class ZombieClusters {
    public int zombieClusters(int[][] zombies){
        int[] visited = new int[zombies.length];
        int count = 0;
        for(int i = 0; i < zombies.length; i++){
            if(visited[i] == 0){
                dfs(zombies, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] zombies, int[] visited, int i){
        for(int j = 0; j < zombies.length; j++){
            if(zombies[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(zombies,visited,j);
            }
        }
    }

    public static void main(String[] args){
        int[][] z = {{1,1,0},{1,1,0},{0,0,1}};
        ZombieClusters a = new ZombieClusters();
        System.out.println(a.zombieClusters(z));
    }
}
