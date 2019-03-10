package GoogleInterview;

import java.util.HashMap;
import java.util.Map;

public class MaxSteps {
    public int maxSteps(int n){

        int res = 1;
        for(int i = 2; i <= n; i++){
            res = Math.max(res, steps(i));
        }
        return res;
    }
    private int steps(int i){
        if(i <= 1) return 0;

        int step = 1 + steps(i % 2 == 0 ? i/2 : 3*i +1);

        return step;
    }

    //因为有很多重复计算， 用hashMap存重复值

    public int MaxSteps2(int n){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,0);
        int res = 0;
        for(int i = 2; i <= n; i++){
            //res = steps2(i,map);
            res = Math.max(res, steps2(i, map));
        }
        return res;
    }

    private int steps2(int i, Map<Integer,Integer> map){
        if(map.containsKey(i)) return map.get(i);

        int step = 1 + steps2(i % 2 == 0 ? i/2 : i*3 + 1, map);

        map.put(i, step);

        return step;
    }

    public static void main(String[] args){
        MaxSteps a = new MaxSteps();
        System.out.println(a.steps(3));
    }
}
