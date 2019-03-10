package LinkedInOA;

import java.util.Stack;

public class Braces {
    public String[] braces(String[] s){
        String[] res = new String[s.length];
        for(int j = 0; j < s.length; j++){
            Stack<Character> stack = new Stack<>();
            String mark = "";
            for(int i = 0; i < s[j].length(); i++){
                if(s[j].charAt(i) == '(' ){
                    stack.push(')');
                }else if(s[j].charAt(i) == '{'){
                    stack.push('}');
                }else if(s[j].charAt(i) == '['){
                    stack.push(']');
                }else if(stack.isEmpty() || s[j].charAt(i) != stack.pop()){
                    mark = "NO";
                    break;
                }
            }
            if(stack.isEmpty() && !mark.equals("NO")) res[j] = "YES";
            else res[j] = "NO";
        }
        return res;
    }

    public static void main(String[] args){
        String[] s = {"{}[]()", "{][]","({[]})","(}", "{[}]}"};
        Braces b = new Braces();
        String[] c = b.braces(s);
        for(String str : c){
            System.out.println(str);
        }

    }
}
