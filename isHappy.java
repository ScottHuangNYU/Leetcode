package leetcode;

import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public boolean isHappy(int n) {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        while(true){
            String num = String.valueOf(sum);
            char[] cn = num.toCharArray();
            sum = 0;
            for(Character c : cn){
                sum += (c - '0')*(c - '0');
            }
            if(sum == 1) return true;
            if(set.contains(sum)) break;
            set.add(sum);


        }
        return false;
    }

    public static void main(String[] args){
        isHappy a = new isHappy();
        System.out.println(a.isHappy(19));
    }
}
