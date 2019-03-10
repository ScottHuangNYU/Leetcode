package ipsyOA;

public class maxDifference {

    public static int solution(int[] arr){
        if(arr.length == 0) return -1;
        int leftMin = arr[0];
        int diff = -1;
        int res = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > leftMin){
                diff = arr[i] - leftMin;
            }else{
                leftMin = arr[i];
            }
            res = Math.max(res, diff);
        }
        return diff == -1 ? -1 : res;
    }
    public static void main(String[] args){
        int[] arr = {2,2,2,2,2,2};
        System.out.println(solution(arr));
    }
}
