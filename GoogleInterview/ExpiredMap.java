package GoogleInterview;

import java.util.HashMap;
import java.util.Map;

public class ExpiredMap {
    class Node{
        int key, val;
        long time;
        public Node(int k, int v){
            key = k;
            val = v;
            time = System.currentTimeMillis();
        }
    }

    private Map<Integer, Node> map;
    private Node[] arr;
    private int expTime;
    public ExpiredMap(int expTime){
        map = new HashMap<>();
        arr = new Node[expTime];
        this.expTime = expTime;
    }

    public Integer get(int key){
        if(map.containsKey(key) && isExpired(map.get(key))){
            map.remove(key);
            return null;
        }
        return map.containsKey(key) ? map.get(key).val : null;
    }

    public void set(int key, int val){
        int index = (int)(System.currentTimeMillis() % expTime);
        if(arr[index] != null){
            map.remove(arr[index].key);
        }
        arr[index] = new Node(key,val);
        map.put(key,arr[index]);
    }

    public void clean(){
        for(Node node : arr){
            if(isExpired(node)) map.remove(node.key);
        }
    }

    public boolean isExpired(Node node){
        return System.currentTimeMillis() - node.time >= expTime;
    }
}
