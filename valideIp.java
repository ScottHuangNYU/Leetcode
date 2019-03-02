package leetcode;

import java.util.ArrayList;
import java.util.List;

public class valideIp {

    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return new ArrayList<>();

        List<String> res = new ArrayList<>();


        backtracking(s, 0, 1, new ArrayList<String>(), res);

        return res;
    }

    public void backtracking(String s, int start, int index, List<String> temp, List<String> res){
        if(temp.size() == 4){
            if(index-1 == s.length()){
                String str = "";
                for(int i = 0; i < 4; i++){
                    str += temp.get(i) + ".";
                }
                res.add(str.substring(0, str.length()-1));
            }
            return;
        }

        for(int i = index; i <= s.length(); i++){
            String sub = s.substring(start, i);
            if(sub.length() > 3 || Integer.valueOf(sub) >= 256 || (sub.length() > 1 && sub.startsWith("0"))) break;
            temp.add(sub);
            backtracking(s, i,i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args){
        valideIp a = new valideIp();
        System.out.println(a.restoreIpAddresses("25525511135"));
    }
}
