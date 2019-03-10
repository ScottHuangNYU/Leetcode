package GoogleInterview;

public class MinDiffLeftSumAndRightSum {
    public int solution(int[] nums){
        if(nums == null || nums.length == 0) return -1;

        int minDiff = Integer.MAX_VALUE, leftSum = 0, rightSum = 0, sum = 0,res = -1;

        for(int num : nums){
            sum += num;
        }

        for(int i = 1; i < nums.length; i++){
            leftSum += nums[i - 1];
            rightSum = sum - leftSum - nums[i];
            if(Math.abs(leftSum - rightSum) < minDiff){
                minDiff = Math.abs(leftSum - rightSum);
                res = i;
            }
        }
        if(sum - nums[0] <= minDiff) res = 0;
        return res;
    }
    public static void main(String[] args){
        int[] nums = {1,3,-7,-4,6,1,-3,4};
        MinDiffLeftSumAndRightSum a = new MinDiffLeftSumAndRightSum();
        System.out.println(a.solution(nums));
    }
}
