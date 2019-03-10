package LinkedInOA;

import java.util.HashSet;
import java.util.Set;

public class DistinctPair {
    public int distinctPair(int[] nums, long k){
        if(nums == null || nums.length == 0) return 0;
        Set<Long> set = new HashSet<>();
        int count = 0;
        for(int num : nums){
            if((long) num == k / 2 && set.contains((long) num)){
                count++;
            }
            if(!set.contains((long)num)){
                if(set.contains((long)(k - num))){
                    count++;
                }

            }
            set.add((long) num);
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {6,6,3,9,3,5,1};
        DistinctPair a = new DistinctPair();
        System.out.println(a.distinctPair(nums,12));
    }
}
