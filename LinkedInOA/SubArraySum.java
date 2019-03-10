package LinkedInOA;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class SubArraySum {
    public static long subArraySum(List<Integer> arr){
        int n = arr.size();
        long sum = 0;

        for(int i = 0; i < n; i++){
            sum += arr.get(i) * (n - i) *(i + 1);
        }
        return sum;
    }
    //we count how many times each element in the list appear.
    //first part : this elemnet is the first element of the sublist like: for 2: {2,3} and {2}
    //second part : this element isnot the first element of the sublist like for 2: {1,2,3} and {1,2}

    //for the first part: these subarray has (n - i)
    //for the second part: these subarray has i(n - i) i: 这个元素前面有多少个元素可能为first element， （n - i)： 这个元素的后面有多少个元素可能+到sublist

    public static void main(String[] args){
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        SubArraySum c = new SubArraySum();
        System.out.println(c.subArraySum(a));
    }
}
