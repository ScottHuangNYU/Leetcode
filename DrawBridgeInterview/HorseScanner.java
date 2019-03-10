package DrawBridgeInterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HorseScanner {

    private Map<Integer,Node> record;
    private LinkedList<Node>[] order;
    private Node[] head;
    private Node[] tail;
    class Node{
        int scanner;
        int horse;
        int time;
        Node next;
        Node pre;
        public Node(int scanner, int horse, int time){
            this.scanner = scanner;
            this.horse = horse;
            this.time = time;
        }
    }

    public HorseScanner(int numScanner){
        record = new HashMap<>();
        order = new LinkedList[numScanner];
        head = new Node[numScanner];
        tail = new Node[numScanner];
        for(int i = 0; i < numScanner; i++){
            head[i] = new Node(0,0,0);
            tail[i] = new Node(0,0,0);
            head[i].pre = null;
            head[i].next = tail[i];
            tail[i].pre = head[i];
            tail[i].next = null;
        }

    }

    public void deleteNode(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void insertToTail(Node node){
        node.pre = tail[node.scanner - 1].pre;
        tail[node.scanner -1].pre.next = node;
        tail[node.scanner-1].pre = node;
        node.next = tail[node.scanner-1];

    }

    public void insertRecord(int scanner, int horse, int time){
        if(!record.containsKey(horse)){
            Node node = new Node(scanner,horse,time);
            record.put(horse,node);
            insertToTail(node);
        }else{
            Node node = record.get(horse);
            Node newNode = new Node(scanner,horse,time);
            deleteNode(node);
            record.put(horse,newNode);
            insertToTail(newNode);
            //node.scanner = scanner;
            //node.time = time;
        }
    }

    public void printOrder(){
        for(int i = head.length - 1; i >= 0; i--){
            Node h = head[i];
            Node t = tail[i];
            Node cur = h.next;
            while(cur != t) {
                System.out.println(cur.horse);
                cur = cur.next;
            }
            System.out.println("----");
        }
    }

    public static void main(String[] args){
        HorseScanner a = new HorseScanner(3);
        a.insertRecord(1,1,2);
        a.insertRecord(1,2,4);
        a.insertRecord(2,1,5);
        a.insertRecord(1,3,6);
        a.insertRecord(2,3,8);
        a.insertRecord(3,1,9);

        a.printOrder();
    }
}
