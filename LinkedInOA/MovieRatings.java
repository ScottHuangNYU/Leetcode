package LinkedInOA;

public class MovieRatings {
    public int movieRating(int[] nums){
        int preTake = nums[0];
        int preSkip = 0;

        for(int i = 1; i < nums.length; i++){
            int curTake = nums[i] + Math.max(preTake, preSkip);
            int curSkip = preTake;
            preSkip = curSkip;
            preTake = curTake;
        }
        return Math.max(preSkip, preTake);
    }

    public static void main(String[] args){
        int[] nums = {5,9, -1,-3,4,5};
        MovieRatings a = new MovieRatings();
        System.out.println(a.movieRating(nums));
    }
}
