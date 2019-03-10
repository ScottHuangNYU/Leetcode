package GoogleInterview;

import java.util.HashMap;
import java.util.Map;

public class minSubArray {
    public static int solution(int[] coupons){
        if(coupons == null || coupons.length == 0) return -1;

        int res = Integer.MAX_VALUE;

        for(int start = 0; start < coupons.length; start++){
            int left = coupons[start];

            for(int end = start + 1; end < coupons.length; end++){
                if(coupons[end] == left){
                    res = Math.min(res, end - start + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int solution1(int[] coupons){
        if(coupons == null || coupons.length == 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < coupons.length; i++){
            if(!map.containsKey(coupons[i])) {
                map.put(coupons[i], i);
            }else{
                res = Math.min(res, i - map.get(coupons[i])+ 1);
                map.put(coupons[i], i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args){
       int[] a = new int[]{5,3,4,2,3,4,6,5};

        System.out.println(solution1(a));
    }
}
