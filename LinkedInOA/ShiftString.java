package LinkedInOA;

public class ShiftString {
    public String shiftString(String s, int leftShift, int rightShift){
        if(s == null || s.length() == 0) return s;

        int shift = (leftShift - rightShift) % s.length();

        if(shift > 0){
            return s.substring(shift) + s.substring(0, shift);
        }else if(shift < 0){
            return s.substring(s.length() + shift) + s.substring(0, s.length() + shift);
        }
        return s;
    }

    public static void main(String[] args){
        String a = "abcde";
        ShiftString c = new ShiftString();
        System.out.println(c.shiftString(a,3,5));
    }

}
