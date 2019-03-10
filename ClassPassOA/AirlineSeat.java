package ClassPassOA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AirlineSeat {
    public int countAvailableSear(String s, int n){
        if(s == null || s.length() == 0) return n * 3;

        Map<Integer, Set<Character>[]> map = new HashMap<>();

        String[] strs = s.split(" ");

        for(String str : strs){
            int line = Integer.parseInt(str.substring(0,str.length() - 1));
            char seat = str.charAt(str.length() - 1);
            Set<Character>[] setArr;
            if(!map.containsKey(line)){
                setArr = new Set[3];
                setArr[0] = new HashSet<>();
                setArr[1] = new HashSet<>();
                setArr[2] = new HashSet<>();
            }else{
                setArr = map.get(line);
            }
            if(seat == 'A' || seat == 'B' || seat == 'C' ) setArr[0].add(seat);
            if(seat == 'D' || seat == 'E' || seat == 'F' || seat == 'G') setArr[1].add(seat);
            if(seat == 'H' || seat == 'J' || seat == 'K' ) setArr[2].add(seat);
            map.put(line,setArr);
        }

        int count = 0;

        for(Map.Entry<Integer, Set<Character>[]> entry : map.entrySet()){
            Set<Character>[] setArr = entry.getValue();
            if(setArr[0].size() > 0) count++;
            if(setArr[2].size() > 0) count++;
            if(setArr[1].size() > 1 || setArr[1].contains('E') || setArr[1].contains('F')) count++;
        }
        return n * 3 - count;
    }

    public static void main(String[] args){
        String s = "1A 1E 2E 1K 2B 2J";
        AirlineSeat a = new AirlineSeat();
        System.out.println(a.countAvailableSear(s,2));
    }
}
