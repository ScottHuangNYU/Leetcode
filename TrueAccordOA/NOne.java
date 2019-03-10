package TrueAccordOA;

public class NOne {

    public static String solution(String message){
        char[] chars = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int count = 1;

        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i - 1]) {
                count++;
            }else{
                if(count != 1){
                    sb.append(count);
                    count = 1;
                }
                sb.append(chars[i]);
            }
        }

        return count == 1 ? sb.toString() : sb.append(count).toString();
    }

    public static void main(String[] args){
        String s = "alsssaheegg";
        System.out.println(solution(s));
    }
}
