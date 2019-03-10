package GoogleInterview;

import twilioOA.TranslateDate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransferLetter {
    public boolean CanBeTransfer(String s1, String s2){
        Map<Character,Character> map = new HashMap<>();
        if(s1.length() != s2.length()) return false;

        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(map.containsKey(c1) && map.get(c1) != c2) return false;
            else if(!map.containsKey(c1)){
                map.put(c1,c2);
            }
        }
        Set<Character> set = new HashSet<>();
        for(Character key : map.keySet()){
            set.add(map.get(key));
        }
        if(map.size() == 26 && set.size() == 26) return false;

        return true;
    }

    public static void main(String[] args){
        TransferLetter a = new TransferLetter();
        System.out.println(a.CanBeTransfer("bcdefghijklmnopqrstuvwxyz","yxwvutsrqponmlkjihgfedcba"));
    }
}
