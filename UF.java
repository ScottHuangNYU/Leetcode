package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UF {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;

        for(int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2) {
                roots[root1] = root2;  // union
                n--;
            }
        }
        return n;
    }

    public int find(int[] roots, int id) {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }

    public static void main(String[] args){
        int[][] edges = {{0,1}, {1,2}, {2,3},{3,4}};
        UF a = new UF();
        System.out.println(a.countComponents(5,edges));
    }
}
