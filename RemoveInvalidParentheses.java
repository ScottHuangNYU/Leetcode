package leetcode;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()){
            String cur = queue.poll();

            if(isValid(cur)){
                res.add(cur);
                found = true;
            }

            if(found) continue;

            for(int i = 0; i < cur.length(); i++){
                char c = cur.charAt(i);

                if(c != '(' && c != ')') continue;

                String temp = cur.substring(0, i) + cur.substring(i + 1);

                if(!visited.contains(temp)){
                    queue.offer(temp);
                    visited.add(temp);
                }
            }
        }
        return res;
    }

    public boolean isValid(String s){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')' && count-- == 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args){
        String s = "()())()";
        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        System.out.println(a.removeInvalidParentheses(s));
    }
}
