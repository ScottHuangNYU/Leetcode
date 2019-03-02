package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0; int maxLength = Integer.MIN_VALUE;
        int start = 0;
        for(int end = 0; end < s.length(); end++){

            char cur = s.charAt(end);

            if(map.containsKey(cur)){
                if(map.get(cur) == 0){
                    count++;
                }
                map.put(cur, map.get(cur) + 1);
            }else{
                map.put(cur, 1);
                count++;
            }

            while(count > 2){
                char c = s.charAt(start);
                start += 1;
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {count--;}
            }


            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] arg){
        String s = "abcabcabc";
        LengthOfLongestSubstringTwoDistinct a = new LengthOfLongestSubstringTwoDistinct();
        System.out.println(a.lengthOfLongestSubstringTwoDistinct(s));
    }
}
