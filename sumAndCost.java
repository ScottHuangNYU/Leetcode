package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class sumAndCost {
    public int sumAndCost(Integer[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(arr));
        int sum = priorityQueue.poll();
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            int currentElement = priorityQueue.poll();
            if (currentElement < sum) {
                priorityQueue.add(sum);
                sum = currentElement;
            } else {
                sum += currentElement;
                cost += sum;
                continue;
            }

            sum += priorityQueue.poll();
            cost += sum;
        }

        return cost ;
    }

    public static void main(String[] args){
        sumAndCost ss = new sumAndCost();
        Integer[] a = new Integer[]{1,1,2,2,3};
        System.out.println(ss.sumAndCost(a));
    }
}
