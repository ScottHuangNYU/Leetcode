package GoogleInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommoditySystem {
    class Node{
        int offerID, productID, price;
        public Node(int oI, int pI, int price){
            offerID = oI;
            productID = pI;
            this.price = price;
        }
    }

    private Map<Integer, Node> offerMap;
    private Map<Integer, List<Node>> productMap;

    public CommoditySystem(){
        offerMap = new HashMap<>();
        productMap = new HashMap<>();
    }

    public void add(int offerID, int productID, int price){
        Node node = new Node(offerID,productID,price);
        offerMap.put(offerID,node);
        if(productMap.containsKey(productID)){
            productMap.get(productID).add(node);
        }else{
            List<Node> list = new ArrayList<>();
            list.add(node);
            productMap.put(productID,list);
        }

    }

    public void remove(int offerID){
        if(offerMap.containsKey(offerID)){
            int productID= offerMap.get(offerID).productID;
            offerMap.remove(offerID);
            if(productMap.containsKey(productID)){
                List<Node> list = productMap.get(productID);
                for(Node node : list){
                    if(node.offerID == offerID){
                        list.remove(node);
                        break;
                    }
                }
            }
        }
    }

    public int search(int productID, int price){
        int mindiff = Integer.MAX_VALUE;
        int res = -1;
        if(productMap.containsKey(productID)){
            List<Node> list = productMap.get(productID);
            for(Node node : list){
                if(Math.abs(node.price - price) < mindiff){
                    mindiff = Math.abs(node.price - price);
                    res = node.offerID;
                }
            }
        }
        return res;
    }
    public void print(){
        for(Map.Entry<Integer,Node> entry : offerMap.entrySet()){
            System.out.print(entry.getKey() + "  "+ "price: " + entry.getValue().price + "  pID : " + entry.getValue().productID );
            System.out.println();
        }
    }

    public static void main(String[] args){
        CommoditySystem map = new CommoditySystem();
        map.add(1,1,10);
        map.add(2,1,20);
        map.add(3,1,8);
        map.add(4,2,50);
        map.add(5,2,100);
        map.add(6,2,80);

        map.print();

        System.out.println("==========");
        System.out.println(map.search(1,21));
        map.remove(2);
        System.out.println("------");
        map.print();
        System.out.println(map.search(1,21));
    }
}
