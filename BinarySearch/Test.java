package leetcode.BinarySearch;

public class Test {
    public  static void reverseString(char[] s){
        String str = String.valueOf(s);
        System.out.println(str);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb.toString());
        s = sb.toString().toCharArray();
        System.out.println(s);
    }

    public static void main(String[] args){
        reverseString(new char[]{'h','e','l','o'});
    }
}
