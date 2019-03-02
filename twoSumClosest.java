package leetcode;
import java.util.*;

public class twoSumClosest {
    public int twoSumClosest(int[] nums, int target){

        Arrays.sort(nums);
        int result = nums[0] + nums[nums.length-1];
        int left = 0; int right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] == target) return target;
            else if(nums[left] + nums[right] > target){
                if(Math.abs(target - (nums[left]+nums[right])) < Math.abs(target - result)){
                    result = nums[left]+nums[right];
                }
                right--;
            }
            else{
                if(Math.abs(target - (nums[left]+nums[right])) < Math.abs(target - result)){
                    result = nums[left]+nums[right];
                }
                left++;
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {-1,-3,2,3,6,8};
        twoSumClosest two = new twoSumClosest();
        System.out.println(two.twoSumClosest(a,0));
    }
}
