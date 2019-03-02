package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if(k == 0 ) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, new ArrayList<>(), res, 1);
        return res;
    }

    public void backtracking(int n, int k, List<Integer> temp, List<List<Integer>> res, int start){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= n; i++){
            temp.add(i);
            backtracking(n, k, temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args){
        Combinations a = new Combinations();
        a.combine(4,2);
    }
}
