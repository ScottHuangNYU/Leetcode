package leetcode.BinarySearch;

public class SearchRotateII {
    public static boolean search(int[] nums, int target) {

        if(nums.length == 0 || nums == null) return false;

        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == target) return true;
            boolean isDuplicated = false;

            while(mid >= left && nums[mid] == nums[left]){
                left++;
                isDuplicated = true;
            }
            while(mid <= right && nums[mid] == nums[right]){
                right--;
                isDuplicated = true;
            }

            if(isDuplicated) continue;

            if(nums[mid] >= nums[left]){
                if(target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }else{
                if(target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
