package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), 0, res);
        return res;
    }

    private void backtracking(int[] nums, List<Integer> temp, int start, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtracking(nums, temp, i + 1, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        subsetsWithDup a = new subsetsWithDup();
        int[] b = {1,2,2};
        System.out.println(a.subsetsWithDup(b));
    }
}
