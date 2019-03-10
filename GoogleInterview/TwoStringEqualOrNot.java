package GoogleInterview;

import java.util.Stack;

public class TwoStringEqualOrNot {
    public boolean solution(String s1, String s2){
        if(s1 == null) return s2 == null;

        Stack<Character> stack = new Stack<>();

        for(int i =0; i < s1.length(); i++){
            if(s1.charAt(i) == '\\' && s1.charAt(i + 1) == 'b'){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                i++;
            }else{
                stack.push(s1.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        String s = sb.toString();
        if(s.length() != s2.length()) return false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        TwoStringEqualOrNot a = new TwoStringEqualOrNot();
        System.out.println(a.solution("\\bas\\bsc", "asc"));
    }
}
