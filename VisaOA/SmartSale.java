package VisaOA;

import java.util.*;

public class SmartSale {
    public int smartSale(int[] ids, int m){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int id : ids){
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry.getValue());
            res++;
        }

        while(!pq.isEmpty() && m > 0){
            if(m >= pq.peek()){
                m -= pq.poll();
                res--;
            }else{
                return res;
            }
        }
        return res;
    }
}
