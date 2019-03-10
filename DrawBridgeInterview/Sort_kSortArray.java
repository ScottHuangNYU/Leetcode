package DrawBridgeInterview;

import java.util.PriorityQueue;

public class Sort_kSortArray {
    //k + (n - k)logk
    public void sortK(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k + 1; i++){
            pq.offer(nums[i]);
        }
        int index = 0;
        for(int i = k + 1; i < nums.length; i++){
            nums[index++] = pq.poll();
            pq.offer(nums[i]);
        }

        while(!pq.isEmpty()) nums[index++] = pq.poll();
    }
    // nk
    public void insertionSort(int[] nums){

        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > cur){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }


    public static void main(String[] args){
        int[] nums = {1,4,5,2,3,7,8,6,10,9};
        Sort_kSortArray a = new Sort_kSortArray();
        //a.sortK(nums,2);
        a.insertionSort(nums);
        for(int num: nums){
            System.out.println(num);
        }

    }
}
