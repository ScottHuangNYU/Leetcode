package ipsyOA;

import java.util.HashMap;
import java.util.Map;

public class electionWinner {
    public static String solution(String[] strs){
        Map<String, Integer> map = new HashMap<>();

        for(String s: strs){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String Winner = "";
        int count = 0;

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > count){
                Winner = entry.getKey();
                count = entry.getValue();
            }
            if(entry.getValue() == count && entry.getKey().compareTo(Winner) > 0){
                Winner = entry.getKey();
            }
        }
        return Winner;
    }
    public static void main(String[] args){
        //String[] strs = {"Alex","Michael","Harry","Dave","Michael","Victor","Harry","Alex","Mary","Mary"};
        String[] strs = {"Joe","Mar","Joe","Mar"};
        System.out.println(solution(strs));
    }
}
