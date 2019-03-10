package LinkedInOA;



public class LastSubstring {
    public String lastSubstring(String s){
        String temp = "";
        String res = s;
        char max = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) > max){
                res = s.substring(i,s.length());
                max = s.charAt(i);
            }else if(s.charAt(i) == max){
                temp = s.substring(i, s.length());
                int j = 0, k = 0;
                while(j < temp.length()){
                    if(temp.charAt(j) < res.charAt(k)){
                        break;
                    }else if(temp.charAt(j) > res.charAt(k)){
                        res = temp;
                        break;
                    }
                    j++;
                    k++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "acfbfaff";
        LastSubstring a = new LastSubstring();
        System.out.println(a.lastSubstring(s));
    }
}
