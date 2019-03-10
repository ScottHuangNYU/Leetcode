package GoogleInterview;

public class KClosestPoints {
    public int[][] solution(int[][] points, int[] op, int k){
        int[][] res = new int[k][2];

        int[] distance = new int[points.length];
        for(int i = 0; i < points.length; i++){
            distance[i] = (points[i][0] - op[0]) * (points[i][0] - op[0]) + (points[i][1] - op[1]) *(points[i][1] - op[1]);
        }

        for(int i = 0; i < k; i++){
            for(int j = 0; j < points.length - 1 - i; j++){
                if(distance[j] < distance[j + 1]){
                    int[] temp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = temp;
                    int td = distance[j];
                    distance[j] = distance[j + 1];
                    distance[j + 1] = td;
                }
            }
            res[i] = points[points.length - 1 - i];
        }
        return res;
    }

    public static void main(String[] args){
        int[][] points = {{2,5}, {1,1}, {5,6},{4,4},{5,7}};
        int[] op = {0,0};
        KClosestPoints a = new KClosestPoints();
        for(int[] c : a.solution(points,op,3)){
            for(int cc : c){
                System.out.print(cc + " ");
            }
            System.out.println();
        }
    }
}
