package LinkedInOA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortByFrequency {
    public int[] sortByFrequency(int[] nums){
        Map<Integer, Integer> cmap = new HashMap<>();
        Integer[] a = new Integer[nums.length];
        int i = 0;
        for(int num : nums){
            a[i] = num;
            cmap.put(num, cmap.getOrDefault(num, 0) + 1);
        }


        Arrays.sort(a, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                Integer c1 = cmap.get(o1);
                Integer c2 = cmap.get(o2);

                if (c1 != c2) {
                    return Integer.compare(c1, c2);
                }
                else {
                    return Integer.compare(o1, o2);
                }
            }
        });
        for(int j = 0; j < nums.length; j++){
            nums[j] = a[j];
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = {8,5,5,5,5,1,1,3,3,4};
        SortByFrequency a = new SortByFrequency();
        for(int i = 0; i < nums.length; i++){
            System.out.println(a.sortByFrequency(nums));
        }
    }
}
