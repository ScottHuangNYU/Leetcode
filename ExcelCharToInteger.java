package leetcode;

public class ExcelCharToInteger {
    public static int titleToNumber(String s) {
        int sum = 0;
        int weight = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            sum += weight * 26 + s.charAt(i) - 'A' + 1;
            weight++;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(titleToNumber("A"));
    }
}
