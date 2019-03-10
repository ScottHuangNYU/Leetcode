package LinkedInOA;

import java.util.*;

public class StickCut {
    public List<Integer> stickCut(int[] arr){
        Arrays.sort(arr);
        List<Integer> res = new LinkedList<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int num : arr){
            queue.offer(num);
        }

        while(queue.size() > 0){
            int base = queue.poll();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int rest = queue.poll() - base;
                if(rest > 0){
                    queue.offer(rest);
                }
            }
            res.add(queue.size());
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {18,7,10,9,6,6,7,13};
        StickCut a = new StickCut();
        List<Integer> c = a.stickCut(arr);
        for(int cc : c){
            System.out.println(cc);
        }
    }
}
