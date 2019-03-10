package VisaOA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Website_Pagination {
    public List<String> solution(String[][] items, int sp, int so, int x, int y) {
        if (items == null || items.length == 0 || items[0].length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(items, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(sp == 0){
                    return so == 0 ? o1[0].compareTo(o2[0]) : o2[0].compareTo(o1[0]);
                }
                return so == 0? Integer.valueOf(o1[sp])-Integer.valueOf(o2[sp]) : Integer.valueOf(o2[sp])-Integer.valueOf(o1[sp]);
            }
        });
        List<String> result = new ArrayList<>();
        for (int i = x*y; i < Math.min(x*y+x, items.length); i++) {
            result.add(items[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        Website_Pagination test = new Website_Pagination();
        String[][] items = new String[][]{{"item4", "10", "5"}, {"item2", "3", "4"}, {"item3", "17", "8"}};
        for (String name : test.solution(items, 0, 0, 2, 1)) {
            System.out.println(name);
        }
    }
}
