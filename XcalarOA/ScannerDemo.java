package XcalarOA;

import java.util.*;

public class ScannerDemo {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("z");
        set.add("c");

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for(String s : list){
            System.out.println(s);
        }

        list.remove("c");
        list.add("c");

        for(String s : list){
            System.out.println("--------");
            System.out.println(s);
        }
    }
}
