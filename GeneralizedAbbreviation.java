package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();

        backtracking(word, 0, 0, "", res);
        return res;
    }

    public void backtracking(String word, int pos, int count, String temp, List<String> res){
        if(pos  == word.length()){
            if(count > 0) temp += count;
            res.add(temp);
            return;
        }

        //keep the character
        backtracking(word, pos + 1, 0, temp + (count > 0 ? count : "") + word.charAt(pos), res);
        //turn character to digit
        backtracking(word, pos + 1, count + 1, temp, res);
    }

    public static void main(String[] args){
        GeneralizedAbbreviation a = new GeneralizedAbbreviation();
        System.out.println(a.generateAbbreviations("word"));
    }
}
