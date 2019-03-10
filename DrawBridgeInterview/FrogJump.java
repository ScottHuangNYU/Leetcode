package DrawBridgeInterview;

import VisaOA.FindTheSubstring;

import java.util.LinkedList;
import java.util.Queue;

public class FrogJump {
    public int findJumpTimes(int k){
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        int curNums = 1;
        int nextNums = 0;
        int i = 1;

        queue.offer(0);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == k) return level;
            curNums--;
            queue.offer(cur + i);
            queue.offer(cur - i);
            nextNums += 2;

            if(curNums == 0){
                level++;
                i++;
                curNums = nextNums;
                nextNums = 0;
            }
        }
        return level;
     }
     public static void main(String[] args){
        FrogJump a = new FrogJump();
         System.out.println(a.findJumpTimes(7));
     }
}
