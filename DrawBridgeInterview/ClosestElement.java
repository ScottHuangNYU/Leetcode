package DrawBridgeInterview;

public class ClosestElement {
    public int closetElement(int[] arr, int k){
        if(arr == null || arr.length == 0) return 0;

        int left = 0, right = arr.length - 1;

        //if(k >= arr[right]) return arr[right];
        //if(k <= arr[left]) return arr[left];

        while(left < right){
            int mid = (right - left) / 2 + left;

            if(arr[mid] == k) return k;

            else if(arr[mid] < k){
                if(mid < arr.length - 1 && arr[mid + 1] > k){
                    if((k - arr[mid]) <= (arr[mid + 1] - k)) return arr[mid];
                    else return arr[mid];
                }else{
                    left = mid + 1;
                }
            }else{
                if(mid > 0 && arr[mid - 1] < k) {
                    if (k - arr[mid - 1] <= arr[mid] - k) return arr[mid - 1];
                    else return arr[mid];
                }
                right = mid - 1;
            }
        }
        return arr[left];
    }
    public static void main(String[] args){
        int[] arr = {3,4,6,8,9,12,14,20};
        ClosestElement a = new ClosestElement();
        System.out.println(a.closetElement(arr,27));
    }
}
