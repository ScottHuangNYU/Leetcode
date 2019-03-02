package leetcode;


import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] next = new int[nums.length];

        for(int j = 0; j < nums.length; j++){
            next[j] = -1;
        }

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                next[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return next;
    }

    public static void main(String[] args){
        NextGreaterElement a = new NextGreaterElement();
        int[] b = {1,3,5,10,2,7,9};
        int[] c = a.nextGreaterElement(b);
        for(int i = 0; i < b.length;i++){
            System.out.println(c[i]);
        }

    }

}
