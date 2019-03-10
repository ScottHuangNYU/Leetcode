package VisaOA;

public class FindTheWinner {
    public String findTheWinner(int[] a, int[] m, String s) {
        int scoresM = 0, scoresA = 0;
        int[] res = new int[2];
        for (int i = 0; i < a.length; i++) {
            if (s.equals("Even")) {
                scoresA += a[i] - m[i];
                scoresM += m[i] - a[i];
                s = "Odd";
            } else if (s.equals("Odd")) {
                s = "Even";
            }



        }
        if (scoresA > scoresM) return "Andrea";
        else if (scoresA < scoresM) return "Maria";
        else return "Tie";
    }

    public static void main(String[] args){
        int[] m = {2,1,3};
        int[] a = {1,2,3};
        String s = "Even";
        FindTheWinner f = new FindTheWinner();

        System.out.println(f.findTheWinner(a,m,s));


    }
}
