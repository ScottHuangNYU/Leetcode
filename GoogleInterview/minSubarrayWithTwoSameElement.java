package GoogleInterview;

import java.util.HashMap;
import java.util.Map;

public class minSubarrayWithTwoSameElement {
    public static int solution(int[] coupons){
        if(coupons == null || coupons.length == 0) return -1;
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < coupons.length; i++){
            if(indexMap.containsKey(coupons[i])){
                res = Math.min(res, i - indexMap.get(coupons[i]) + 1);
            }
                indexMap.put(coupons[i],i);

        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args){
        int[] coupons = {4,3,4,4,1};
        System.out.println(solution(coupons));
    }
}
