package DrawBridgeOA;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BalancedOrNot {
    public List<Integer> balancedOrNot(List<String> expressions, List<Integer> moves){
        if(expressions == null || expressions.size() == 0) return new LinkedList<>();
        List<Integer> res = new LinkedList<>();

        for(int i = 0; i < expressions.size(); i++){
            String expression = expressions.get(i);
            int move = moves.get(i);

            Stack<Character> stack = new Stack<>();
            boolean addYet = false;

            for(char c : expression.toCharArray()){
                if(c == '<'){
                    stack.push('>');
                }else{
                    if(stack.isEmpty()) {
                        if(move > 0){
                            move--;
                        }else{
                            res.add(0);
                            addYet = true;
                            break;
                        }
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!addYet) res.add(stack.isEmpty() ? 1 : 0);
        }

        return res;
    }

    public static void main(String[] args){
        List<String> a = new LinkedList<>();
        a.add("<>>>");
        a.add("<>>><>");
        a.add("<<<<");
        List<Integer> b = new LinkedList<>();
        b.add(2);
        b.add(2);
        b.add(3);
        BalancedOrNot c = new BalancedOrNot();
        List<Integer> d = c.balancedOrNot(a,b);
        for(int dd : d){
            System.out.println(dd);
        }

    }
}
