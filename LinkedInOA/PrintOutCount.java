package LinkedInOA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintOutCount {
    public void printOurCount(int[] arr){
        if(arr == null || arr.length == 0) return;

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();

        for(int i = 0; i < arr.length; i++){
            int count = arr[i];
            if(!map.containsKey(count)){
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                res.add(temp);
                map.put(count, temp);
            }else{
                List<Integer> temp = map.get(count);
                temp.add(i);
            }
            if(map.get(count).size() == count){
                map.remove(count);
            }
        }
        for(List<Integer> l : res){
            for(int n : l){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[] arr = {3,1,1,3,3,3,4,6};
        PrintOutCount a = new PrintOutCount();
        a.printOurCount(arr);
    }
}
