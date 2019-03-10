package guideWireOA;

public class MaxSumOfTwoSubarrayWithGivenLength {

    public static int solution(int[] arr, int K, int L){

        int res = 0;

        for(int i = 0; i <= arr.length - K; i++){
            int Asum = calculateMaxSum(arr, i, K + i -1,K);
            int Bsum = Math.max(calculateMaxSum(arr, 0, i - 1, L),
                    calculateMaxSum(arr, K + i, arr.length - 1, L));
            res = Math.max(res, Asum + Bsum);
        }
        return res;
    }

    private static int calculateMaxSum(int[] arr, int start, int end, int length) {
        int res = 0;
        if(end - start + 1 < length) return res;
        int[] sum = new int[end - start + 1];
        sum[0] = arr[start];

        for(int i = 1; i <= end - start; i++){
            sum[i] = sum[i - 1] + arr[start + i];
        }
        res = sum[length - 1];
        for(int i = 1; i <= end - start +1 - length; i++){
            res = Math.max(res, sum[length + i - 1] - sum[i - 1]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = new int[]{10, 1, 3, 15, 30, 40, 4, 50, 2, 1};
        System.out.println(solution(arr,3,3));
    }
}
