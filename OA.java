package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OA {
    public static List<String> solution(List<String> lines){
        Map<Integer,StringBuilder> map = new HashMap<>();
        for(String line : lines){
            String[] strs = line.split(" ");
            int box = Integer.valueOf(strs[0]), x = Integer.valueOf(strs[1]), y = Integer.valueOf(strs[2]);
            int start = 3;
            int index = y;

            while(start < strs.length){
                int boxL = box;
                if(!map.containsKey(index)){
                    StringBuilder sb = new StringBuilder();
                    map.put(index, sb);
                }
                StringBuilder sb = map.get(index);
                for(int i = 0; i < x; i++){
                    sb.append(" ");
                }
                while(start < strs.length && boxL > strs[start].length()){
                    sb.append(strs[start]);
                    sb.append(" ");
                    boxL -= (strs[start].length() + 1);
                    start++;
                }
                map.put(index, sb);
                index++;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            String temp = map.getOrDefault(i, new StringBuilder()).toString();
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args){
        List<String> a = new ArrayList<>();
        a.add("10 4 0 I love monkeys.");
        System.out.println(solution(a));
    }
}
