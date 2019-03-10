package GoogleInterview;

public class TakeBench {
    class Interval{
        int start, end;
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }
    public int findComfortableSeat(int[] nums){
        boolean flag = false;
        int size = 0;
        int maxStart = -1, maxEnd = -1;
        int start = -1, end = -1;
        for(int i = 0; i < nums.length; i++){
//            if (i == nums.length-1 && nums[i] == 0) {
//                if (size < i-start+1) {
//                    size = i-start+1;
//                    maxStart = start;
//                    maxEnd = i;
//                }
//            } else if (nums[i] == 1) {
//                if (size < i-start) {
//                    size = i-start;
//                    maxStart = start;
//                    maxEnd = i;
//                }
//                start = i+1;
//                while (start < nums.length && nums[start] == 1) {
//                    start++;
//                    i++;
//                }
//            }
            if(nums[i] == 0 && !flag){
                start = i;
                flag = true;
            }
            if(nums[i] == 1 && flag){
                end = i -1;
                flag = false;
            }
            if(i == nums.length - 1 && nums[i] == 0) end = i;
            if(start != -1 && end != -1){
                int s = end - start + 1;
                if(s > size){
                    size = s;
                    maxStart = start;
                    maxEnd = end;
                }
                start = -1;
                end = -1;
            }
        }
        return (maxEnd - maxStart) / 2 + maxStart;
    }

    public static void main(String[] args){
        int[] nums = {1,1,0,1,1,0,1,0,0,0,0,1};
        TakeBench a = new TakeBench();
        System.out.println(a.findComfortableSeat(nums));
    }
}
