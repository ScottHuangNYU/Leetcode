package DrawBridgeInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MissingNumber {
    //when nums  is order
    public int findMissingNum1(int[] nums){
        if(nums == null || nums.length == 0) return -1;
        if(nums[nums.length - 1] != nums.length) return nums.length;

        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == mid){
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        return left;
    }
    public List<Integer> findMissingNum2(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        if(nums[0] != 0) res.add(0);
        for(int i = 0; i < nums.length - 1; i++){
           int next = nums[i + 1];
           int cur = nums[i];
           if(next - cur > 1){
               for(int j = 1; j < next - cur; j++){
                   res.add(cur + j);
               }
           }
        }
        int last = nums[nums.length - 1];
        while(last != k - 1){
            res.add(++last);
        }
        return res;
    }

    public List<Integer> findMissingNum3(int[] nums, int k){
        int count = 0, missNum = k - nums.length;
        List<Integer> res = new LinkedList<>();
        if(nums[0] != 0) res.add(0); count++;
        if(count == missNum) return res;

        for(int i = 0; i < nums.length - 1; i++){
            int next = nums[i + 1];
            int cur = nums[i];
            if(next - cur > 1){
                for(int j = 1; j < next - cur; j++){
                    res.add(cur + j);
                    count++;
                }
            }
            if(count == missNum) break;
        }
        int last = nums[nums.length - 1];
        while(last != k -1){
            res.add(++last);
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums = {1,3,5,7,8,9,10,11};
        MissingNumber m = new MissingNumber();
        System.out.println(m.findMissingNum3(nums,12));
    }
}
