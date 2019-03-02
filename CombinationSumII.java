package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    public void backtracking(int[] candidates, int remain, List<Integer> temp, List<List<Integer>> res, int start){
        if(remain == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < candidates.length ; i++){
            if(remain < 0) break;
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtracking(candidates, remain - candidates[i], temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args){
        CombinationSumII a = new CombinationSumII();
        int[] v = {1,1,2,5,6,7,10};
        System.out.println(a.combinationSum2(v,8));
    }
}
