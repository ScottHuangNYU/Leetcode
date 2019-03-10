package leetcode.BinarySearch;

public class SearchInRotate {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(target == nums[mid]) return mid;

            if(nums[left] <= nums[mid]){
                if(target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{3,1,2},2));
    }
}
