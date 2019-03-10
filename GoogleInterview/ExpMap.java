package GoogleInterview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExpMap {
    private Map<Integer, Node> map;
    private TreeMap<String, List<Integer>> timeMap;
    class Node{
        int key, val;
        String expTime;
        public Node(int key, int val, String time){
            this.key = key;
            this.val = val;
            this.expTime = time;
        }
    }

    public ExpMap(){
        map = new HashMap<>();
        timeMap = new TreeMap<>();
    }

    public Integer get(int key) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();

        if(map.containsKey(key)){
            Date expT = sdf.parse(map.get(key).expTime);
            if(expT.before(now)) return null;
            else return map.get(key).val;
        }
        return null;
    }

    public void set(int key, int val, String time){
        if(map.containsKey(key)){
            String oldTime = map.get(key).expTime;
            map.get(key).expTime = time;
            map.get(key).val = val;
            timeMap.get(oldTime).remove(Integer.valueOf(key));
            if(timeMap.containsKey(time)){
                timeMap.get(time).add(key);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(key);
                timeMap.put(time,list);
            }
        }else{
            Node node = new Node(key,val,time);
            map.put(key,node);
            if(timeMap.containsKey(time)){
                timeMap.get(time).add(key);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                timeMap.put(time, list);
            }
        }
    }

    public void clean() throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for(Map.Entry<String, List<Integer>> entry : timeMap.entrySet()){

            Date recTime = sdf.parse(entry.getKey());
            if(recTime.before(now)){
                List<Integer> keyList = entry.getValue();
                for(Integer key : keyList){
                    map.remove(key);
                }
                //timeMap.remove(entry.getKey());
            }
        }
        for(String key : timeMap.keySet()){
            if(sdf.parse(key).before(now)){
                timeMap.remove(key);
            }
        }
    }
}
