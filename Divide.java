package leetcode;

public class Divide {
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        if(ldividend < ldivisor || ldividend == 0) return 0;
        long d = helper(ldividend, ldivisor);
        int res = 0;
        if(d > Integer.MAX_VALUE){
            res = sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            res = (int)(sign * d);
        }
        return res;
    }

    public static long helper(long a, long b){
        long res = 0;
        while(a >= b){
            res++;
            a -= b;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(divide(-2147483648,1));
    }
}
