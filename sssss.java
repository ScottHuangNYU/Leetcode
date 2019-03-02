package leetcode;

import java.util.LinkedList;
import java.util.List;

public class sssss {
    static int roverMove(int matrixSize, List<String> cmds) {
        int[] start = new int[]{0,0};
        for(String s : cmds){
            if(start[1] < matrixSize - 1 && s.equals("RIGHT")) {start[1] += 1;}

            if(start[1] > 0 && s.equals("Left")) {start[1] -= 1;}

            if(start[0] < matrixSize - 1 && s.equals("DOWN")) {start[0] += 1;}

            if(start[0] > 0 && s.equals("UP")) {start[0] -= 1;}
        }
        return start[0] * matrixSize + start[1];
    }

    public static void main(String[] args){
        List<String> a = new LinkedList<>();
        a.add("UP");
        a.add("DOWN");
        a.add("RIGHT");
        a.add("RIGHT");
        a.add("LEFT");
        a.add("UP");
        System.out.println(roverMove(4,a));
    }
}
