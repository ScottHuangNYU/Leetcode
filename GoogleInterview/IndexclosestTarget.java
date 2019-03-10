package GoogleInterview;

public class IndexclosestTarget {
    public int findIndex(int[] nums, int k){
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        if(k > nums[right]){
            while(right > 0 && nums[right] == nums[right - 1]){
                right--;
            }
            return right;
        }
        if(k < nums[left]){
            return 0;
        }
        while(left < right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == k){
                while(mid > 0 && nums[mid] == nums[mid - 1]){
                    mid--;
                }
                return mid;
            }else if(nums[mid] < k){

                while (mid < right && nums[mid] == nums[mid + 1]){
                    mid++;
                }
                if(nums[mid + 1] > k){
                    int temp = mid;
                    while(temp > 0 && nums[temp] == nums[temp - 1]){
                        temp--;
                    }
                    return k - nums[mid] > nums[mid + 1] - k ? mid + 1 : temp;
                }
                left = mid + 1;
            }else{
                while(mid > left && nums[mid] == nums[mid - 1]){
                    mid--;
                }
                if(nums[mid - 1] < k){
                    int temp = mid - 1;
                    while(temp > 0 && nums[temp] == nums[temp - 1]){
                        temp--;
                    }
                    return k - nums[mid - 1] > nums[mid] - k ? mid : temp;
                }
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] nums = {1,3,3,5,5,6,7,8,9,10};
        IndexclosestTarget a = new IndexclosestTarget();
        System.out.println(a.findIndex(nums,2));
    }
}
