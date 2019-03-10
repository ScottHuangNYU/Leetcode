package GoogleInterview;

public class CountAndSay {
    public String solution(String s){
        int count = 1;
        char say = s.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i -1)){
                count++;
            }else{
                sb.append(String.valueOf(count));
                sb.append(say);
                count = 1;
                say = s.charAt(i);
            }
        }
        sb.append(String.valueOf(count));
        sb.append(say);
        return sb.toString();
    }
    public static void main(String[] args){
        String s = "abbccc";
        CountAndSay a = new CountAndSay();
        System.out.println(a.solution(s));
    }
}
