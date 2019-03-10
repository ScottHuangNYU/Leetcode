package VisaOA;

public class LongestSubarray {
    public int longestSubarray(int[] a, int k){
        if(a == null || a.length == 0) return 0;

        int res = 0, sum = 0;

        for(int start = 0, end = 0; end < a.length; end++){
            sum += a[end];
            if(sum <= k){
                res = Math.max(res, end - start + 1);
            }else{
                sum -= a[start];
                start++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] a = {3,2,1,2,2,4};
        LongestSubarray c = new LongestSubarray();
        System.out.println(c.longestSubarray(a,7));
    }
}
