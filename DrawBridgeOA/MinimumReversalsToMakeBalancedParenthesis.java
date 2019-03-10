package DrawBridgeOA;

import java.util.Stack;

public class MinimumReversalsToMakeBalancedParenthesis {
    public static int solution(String experssion){
        int res = 0;
        Stack<Character> stack = new Stack<>();
        if(experssion.length() % 2 != 0 ) return -1;

        for(char c : experssion.toCharArray()){
            if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();

            if(c1 == c2){
                res += 1;
            }else{
                res += 2;
            }
        }

        return res;
    }

    public static void main(String[] args){
        String s = "{}}}}{";
        System.out.println(solution(s));
    }
}
