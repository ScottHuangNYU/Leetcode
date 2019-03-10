package TrueAccordOA;

public class CountNumOfUniqueNum {
    public static int solution(int[] range){
        int min = range[0];
        int max = range[1];
        int count = 0;

        for(int i = min; i <= max; i++){
            if (isUnique(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean isUnique(int num){
        boolean[] visited = new boolean[10];
         while(num > 0){
             if(visited[num % 10]){
                 return false;
             }
             visited[num % 10] = true;
             num /= 10;
         }
         return true;
    }

    public static void main(String[] args){
        int[] range = new int[2];
        range[0] = 10;
        range[1] = 22;

        System.out.println(solution(range));
    }

}

