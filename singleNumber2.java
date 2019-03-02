package leetcode;

public class singleNumber2 {
    public int singleNumber(int[] nums) {
        int ones = 0; int twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos; // the number of element num[i] when traverse to i.
            twos = (twos ^ nums[i]) & ~ones; // the number of element num[i] when traverse to i.
        }
        return ones;
    }

    public static void main(String[] args){
        singleNumber2 ss = new singleNumber2();
        int[]a = new int[] {2,2,2,3};
        System.out.println(ss.singleNumber(a));
    }
}
