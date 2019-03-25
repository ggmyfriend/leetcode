package Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Base.AnotherNode.Node;

public class CloneGraph {
    HashMap<Node,Node> repeat = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }else{
            Node head = new Node();
            head.val = node.val;
            repeat.put(node,head);
            head.neighbors = recurListNode(node.neighbors);
            return head;
        }
    }
    public List<Node> recurListNode(List<Node> list){
        List<Node> list1 = new ArrayList<>();
        for(Node node1 : list){
            Node node = isRepeat(node1);
            if(node==null){
                Node trueNode = new Node();
                trueNode.val = node1.val;
                repeat.put(node1,trueNode);
                list1.add(trueNode);
                trueNode.neighbors = recurListNode(node1.neighbors);
            }else{
                list1.add(node);
            }
        }
        return list1;
    }
    public Node isRepeat(Node node1){
        for(Map.Entry<Node,Node> tempNode : repeat.entrySet()){
            if(tempNode.getKey() == node1){
                return tempNode.getValue();
            }
        }
        return null;
    }

}
