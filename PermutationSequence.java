package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        for(int i = 1; i < n + 1; i++){
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        k--;
        for(int i = n; i > 0; i--){
            int index = k / factorial[n-1];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - 1];
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(getPermutation(4,9));
    }
}
