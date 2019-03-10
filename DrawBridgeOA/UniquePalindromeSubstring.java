package DrawBridgeOA;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniquePalindromeSubstring {
    Set<String> set = new HashSet<>();
    //int count = 0;
    public Set<String> countPSubstring(String s){
        for(int i = 0; i < s.length(); i++){
            checkIsP(s, i, i);
            checkIsP(s, i, i + 1);
        }
        return set;
    }

    private void checkIsP(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(!set.contains(s.substring(i,j+1))) {
                set.add(s.substring(i, j + 1));
                //count++;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args){
        String s = "abaa";
        UniquePalindromeSubstring a = new UniquePalindromeSubstring();
        Iterator<String> it = a.countPSubstring(s).iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
        //System.out.println(a.countPSubstring(s));
    }
}
