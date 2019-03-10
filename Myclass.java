
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Myclass {



    public static void main(String[] args)  {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int[] arr = {2,3,5,6,1,99,-8};
        for(int i : arr){
            pq.offer(i);
        }

        System.out.println(pq);
        System.out.println(pq.poll());
    }
}
