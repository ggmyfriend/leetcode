package Base;
import Base.TheOtherNode.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CopyListRandomPointer {
    HashMap<Node,Node> hashMap;
    public Node copyRandomList(Node head) {
        hashMap = new HashMap<>();
        Node trueHead = new Node();
        Node pre = trueHead;
        pre.next = head;
        while(head!=null){
            Node containHead = this.containsNode(head);
            if(containHead==null) {
                containHead = new Node();
                containHead.val = head.val;
                hashMap.put(head,containHead);
            }
            pre.next = containHead;
            Node containRamdom = this.containsNode(head.random);
            System.out.println(containRamdom);
            if(head.random!=null) {
                if (containRamdom == null) {
                    containRamdom = new Node();
                    containRamdom.val = head.random.val;
                    hashMap.put(head.random, containRamdom);
                }
            }else{
                containRamdom = null;
            }
            containHead.random = containRamdom;
            pre = containHead;
            head = head.next;
        }
        return trueHead.next;
    }
    public Node containsNode(Node node){
        for(Map.Entry<Node,Node> node1 : hashMap.entrySet()){
            if(node1.getKey()==node){
                return node1.getValue();
            }
        }
        return null;
    }
}
