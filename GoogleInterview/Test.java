package GoogleInterview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date now = new Date();
//        //String curTime = sdf.format(now);
//        System.out.println(now);
//
//        String a = "2018-10-13 01:00:00";
//        Date date = sdf.parse(a);
//        System.out.println(date);
//
//        System.out.println(date.before(now));
//
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        list.remove(Integer.valueOf(0));
//        System.out.println(list);
//
//        Test test = new Test();
//        test.add(4);
//        System.out.println("----" + System.currentTimeMillis());
//        String s = "ansbs";
//        StringBuilder sb = new StringBuilder();
//        for(char c: s.toCharArray()){
//            sb.insert(0,c);
//        }
//        for(char c : sb.toString().toCharArray()){
//            System.out.println(c);
//        }

        char c = '6';
        char d = '2';
        StringBuilder sb = new StringBuilder();
        sb.insert(0,(c -'0'+ d - '0' +1));
        System.out.println(sb.toString());
    }
    static int x = 5;
    public void add(int a) {
        x++;
        System.out.println(a+x);
    }
}
