package leetcode;

import java.util.*;

public class ttt {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            String temp = "";
            for(char c : str.toCharArray()){
                if(c == ' ' || c == '/' ) temp += "/" + c;
                else temp += c;
            }
            sb.append(temp);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static List<String> decode(String s) {

        List<String> res = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            if(i + 1 < s.length() && s.charAt(i) == '/'){
                temp += s.charAt(i + 1);
                i++;
            }else if(s.charAt(i) == ' '){
                res.add(temp);
                temp = "";
            }else{
                temp += String.valueOf(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "";
        String b = "";
        String s = a + "/" + b;
        System.out.println(s +  "changdu: " + s.length());
    }
}

