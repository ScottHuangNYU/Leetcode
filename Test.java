import java.util.*;

public class Test {
    public static boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while(right > left){
            if(s.charAt(left++) == s.charAt(right--)) continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args){

    }
}
