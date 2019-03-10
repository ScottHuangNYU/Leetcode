package GoogleInterview;

public class KtimesBBsort {
    public void solution(int[] nums, int k){
        for(int i = 0; i < k; i++){
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {5,2,4,3,1};
        KtimesBBsort a = new KtimesBBsort();
        a.solution(nums,3);
        for(int n : nums){
            System.out.println(n);
        }
    }
}
