package leetcode;

import java.util.Arrays;

public class compress {
    public int compress(char[] chars) {
        Arrays.sort(chars);
        int length = 0; int count = 1;
        for(int i = 0; i < chars.length; i++){
            if(i == 0 || i > 0 && chars[i] != chars[i - 1]){
                if(count != 1){
                    String same = String.valueOf(count);
                    length += same.length();
                    count = 1;
                }
                length++;
            }
            if(i > 0 && chars[i] == chars[i - 1]){
                count++;
            }

        }
        if(count != 1) length++;
        return length;
    }

    public static void main(String[] args){
        compress a = new compress();
        char[] c = {'a', 'b', 'b','b','b','b','b','b','b','b','b','b','c', 'c','d','e','e'};
        System.out.println(a.compress(c));
    }
}
