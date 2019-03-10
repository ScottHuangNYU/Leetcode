package LinkedInOA;

public class MaximumDifference {
    public int maximunDiff(int[] arr){
        if(arr.length == 0 || arr.length == 1) return -1;
        int maxDiff = -1, min = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - min > maxDiff) maxDiff = arr[i] - min;

            if(arr[i] < min) min = arr[i];
        }
        return maxDiff == -1 ? -1 : maxDiff;
    }
    public static void main(String[] args){
        MaximumDifference a = new MaximumDifference();
        int[] arr = {1, 2, 90, 10, 110, 2, 200};
        System.out.println(a.maximunDiff(arr));
    }
}
