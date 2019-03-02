package leetcode;

import java.util.LinkedList;
import java.util.List;

public class GraphValidTree {
    public static boolean solution(int n, int[][] edges){
        List<List<Integer>> childs = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            childs.add(i, new LinkedList<>());
        }

        for(int[] edge: edges){
            childs.get(edge[0]).add(edge[1]);
            childs.get(edge[1]).add(edge[0]);
        }

        if(hasCycle(childs, 0, -1, visited)) return false;

        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }

    private static boolean hasCycle(List<List<Integer>> childs, int cur, int parent, boolean[] visited){
        visited[cur] = true;
        for(int i = 0; i < childs.get(cur).size(); i++){
            int child = childs.get(cur).get(i);
            if(visited[child] && child != parent || !visited[child] && hasCycle(childs, child, cur, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{4,1}};
        System.out.println(solution(5,edges));
    }
}
