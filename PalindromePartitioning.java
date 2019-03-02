package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return new ArrayList<>();

        List<List<String>> res = new ArrayList<>();

        backtracking(s, 0, 1, new ArrayList<>(), res);

        return res;
    }

    public void backtracking(String s, int start, int end, List<String> temp, List<List<String>> res){
        if(end - 1 == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = end; i <= s.length(); i++){
            String eachString = s.substring(0, i);
            if(isPalindrome(eachString)){
                temp.add(eachString);
                backtracking(s, i, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while(right > left){
            if(s.charAt(left++) == s.charAt(right--)) continue;
            else return false;
        }
        return true;
    }
    public static void main(String[] args){
        PalindromePartitioning A = new PalindromePartitioning();
        System.out.println(A.partition("aab"));
    }
}
