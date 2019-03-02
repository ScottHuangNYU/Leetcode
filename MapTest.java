package leetcode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy"));
        staff.put("567-24-2546", new Employee("Harry"));
        staff.put("157-62-7935", new Employee("Gray"));
        staff.put("456-62-5527", new Employee("France"));
        System.out.println("......" + staff);

        staff.remove("567-24-2546");//删除
        System.out.println(staff);

        staff.put("456-62-5527", new Employee("Bob"));//替换
        System.out.println(staff);

        System.out.println(staff.get("157-62-7935"));//查询
        System.out.println("///////"+staff.entrySet());
        //取得map中所有的key和value
        for(Map.Entry<String, Employee> entry : staff.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value + "");
        }

        //取得map中所有的key
        Set<String> keys = staff.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
        //取得map中所有的value
        Collection<Employee> values = staff.values();
        for(Employee value : values) {
            System.out.println(value);
        }
    }
}

class Employee {
    public Employee(String n) {
        name = n;
        salary = 0;
    }

    public String toString() {
        return "[name=" + name + ", salary=" + salary + "]";
    }
    private String name;
    private double salary;
}
