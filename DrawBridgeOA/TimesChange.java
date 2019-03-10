package DrawBridgeOA;

public class TimesChange {
    public int timesChange(String s){
        int count = 0;
        char[] cArray = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            if(cArray[i] == cArray[i - 1]){
                cArray[i] = '0';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        String s = "abbbccc";
        TimesChange a = new TimesChange();
        System.out.println(a.timesChange(s));
    }
}
