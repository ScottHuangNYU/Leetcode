package GoogleInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueEmail {
    public static int solution(String[] emails){
        Map<String, Integer> map = new HashMap<>();
        for(String email : emails){
            String[] local_domain = email.split("@");
            String[] locals = local_domain[0].split("\\+");
            String local = locals[0];
            local = local.replace(".","");
            map.put(local + "@" + local_domain[1], map.getOrDefault(local + "@" + local_domain[1],0) + 1);
        }
        int max = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args){
        String[] emails = {"abc@d.com", "a.b.c@d.com", "a..bc+hh@d.com", "ab@f.com","a..b@f.com", "ax@d.com"};
        System.out.println(solution(emails));
    }
}
