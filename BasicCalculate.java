package leetcode;

import java.util.Stack;

public class BasicCalculate {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s.replaceAll("  ", "");
        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                curNum = curNum * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(curNum);
                }
                if(sign == '-'){
                    stack.push(-curNum);
                }
                if(sign == '*'){
                    stack.push(curNum * stack.pop());
                }
                if(sign == '/'){
                    stack.push(stack.pop() / curNum);
                }
                sign = s.charAt(i);
                curNum = 0;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args){
        BasicCalculate a = new BasicCalculate();
        String s = "3+5 / 2 ";
        s.replaceAll(" ","");
        System.out.println(s);
        //System.out.println(a.calculate(s));
    }
}
