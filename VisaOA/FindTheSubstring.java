package VisaOA;

public class FindTheSubstring {
    public int firstOccurrence(String a, String b){
        if(a == null) return -1;
        if(b == null) return 0;

        for(int i = 0; i <= a.length() - b.length();i++){
            if(a.charAt(i) == b.charAt(0) || b.charAt(0) == '*'){
                int j = 1;
                while(j < b.length() && (a.charAt(i + j) == b.charAt(j) || b.charAt(j) == '*')){
                    j++;
                }
                if(j == b.length()) return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String a = "xacdey";
        String b = "*de";
        FindTheSubstring f = new FindTheSubstring();
        System.out.println(f.firstOccurrence(a,b));
    }
}
