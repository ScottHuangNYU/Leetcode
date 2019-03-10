package GoogleInterview;

import java.util.*;

public class ExcessFrequency {
    public Set<String> solution(String s){
        String[] strs = s.split(" ");

        Map<String,Integer> map = new HashMap<>();

        for(String str : strs){
            map.put(str,map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                }
        );

        int sum = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
            sum += entry.getValue();
        }

        Set<String> res = new HashSet<>();

        while(!pq.isEmpty()){
            Map.Entry<String, Integer> entry = pq.poll();
            String term = entry.getKey();
            int count = entry.getValue();
            res.add(term);
            if(count >= sum * 0.01) break;
        }

        return res;
    }
}
