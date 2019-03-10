package DrawBridgeOA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BeautifulSubarrays {
    public List<int[]> beautifulSubarrays(int[] a, int m){

        List<int[]> res = new LinkedList<>();
        int count = 0;
        for(int start = 0, end = 0; end < a.length ; end++){
            if(a[end] % 2 != 0) count++;
            while(count > m) {
                if (a[start] % 2 != 0) count--;
                start++;
            }
            if(count == m){
                //res.add(Arrays.copyOfRange(a,start, end + 1));
                helper(a, start, end,res);
            }
        }
        return res;
    }

    private void helper(int[] a, int start, int end, List<int[]> res){
        res.add(Arrays.copyOfRange(a,start, end + 1));
        while(start < end && a[start++] % 2 == 0){
            res.add(Arrays.copyOfRange(a,start, end + 1));
        }
    }

    public static void main(String[] args){
        int[] a = {2,5,4,9};
        BeautifulSubarrays b = new BeautifulSubarrays();
        List<int[]> res = b.beautifulSubarrays(a,1);
        for(int[] aa : res){
            for(int v : aa){
                System.out.println(v);
            }
            System.out.println("-------------");
        }
    }
}
