package GoogleInterview;

import java.util.ArrayList;
import java.util.List;

public class PrintTheCycleInUndirectedGraph {
    private int cycleNum;

    public  void solution(int[][] graph, int  N){

        List<Integer>[] adj = new ArrayList[N];

        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int[] edge :graph){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] color = new int[N];
        int[] cycle = new int[N];
        int[] parent = new int[N];
        cycleNum = 0;

        dfs(1, 0, color, cycle,parent, adj);

        for(int i = 1; i <= cycleNum; i++){
            System.out.print("Cycle Number" + i + ":");
            for(int j = 0; j < N; j++){
                if(cycle[j] == i){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }


    public  void dfs(int v, int p, int[] color, int[] cycle, int[] parent, List<Integer>[] adj){
        if(color[v] == 2) return;

        if(color[v] == 1){
            cycleNum++;
            int cur = p;
            cycle[cur] = cycleNum;

            while (cur != v){
                cur = parent[cur];
                cycle[cur] = cycleNum;
            }


            return;
        }

        color[v] = 1;
        parent[v] = p;

        for(int next: adj[v]){
            if(next == p) continue;

            dfs(next, v, color, cycle, parent, adj);
        }

        color[v] = 2;
    }

    public static void main(String[] args){
        int[][] graph = {{1,2},{2,3},{3,4},{4,6},{4,7},{7,8},{6,5},{6,10},{5,3},{5,9},{10,11},{11,12},{12,13},{11,13}};
        PrintTheCycleInUndirectedGraph a = new PrintTheCycleInUndirectedGraph();
        a.solution(graph,14);
    }
}
