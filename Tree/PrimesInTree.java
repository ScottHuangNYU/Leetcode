package Tree;

import java.util.*;

public class PrimesInTree {
    public List<Integer> solution(int n, List<Integer> first, List<Integer> second, List<Integer> value, List<Integer> queries){
        if(n == 0 || queries == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        List<Integer>[] adj = new List[n + 1];

        for(int i = 1; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < first.size(); i++){
            adj[first.get(i)].add(second.get(i));
            adj[second.get(i)].add(first.get(i));
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[n+1];
        for(int i = 1; i < n + 1; i++){
            if(isPrime(value.get(i - 1))) dp[i] = 1;
        }
        for(int i = 1; i <= n; i++){
            if(adj[i].size() == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int leaf = queue.poll();
            int nei = adj[leaf].get(0);
            dp[nei] += dp[leaf];
            adj[nei].remove(Integer.valueOf(leaf));
            if(adj[nei].size() == 1 && nei != 1) queue.offer(nei);
        }
        for(int i = 0; i < queries.size(); i++){
            res.add(dp[queries.get(i)]);
        }
        return res;
    }

    private boolean isPrime(Integer n) {
        if(n < 2) return false;

        int r = (int) Math.sqrt(n);
        for(int i = 2; i <= r; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        PrimesInTree a = new PrimesInTree();
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 1, 1, 8, 7, 2, 6));
        List<Integer> second = new ArrayList<>(Arrays.asList(2, 8, 4, 3, 8, 6, 5));
        List<Integer> value = new ArrayList<>(Arrays.asList(3,7, 20, 23, 7, 8, 31,19));
        List<Integer> q = new ArrayList<>(Arrays.asList(1, 2,3 , 4, 5,6,7,8));
        System.out.println(a.solution(8,first, second,value,q));

    }
}
