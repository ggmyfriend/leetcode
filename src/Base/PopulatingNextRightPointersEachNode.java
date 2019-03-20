package Base;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulatingNextRightPointersEachNode {
    public Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        recurConnect(root,0,list);
        return root;
    }
    public void recurConnect(Node root,int level,List<Node> list){
        if(root==null){
            return;
        }else{
            Node node;
            if(list.size()<=level){
                list.add(root);
            }else{
                node = list.get(level);
                node.next = root;
                list.set(level,root);
                for(Node n : list){
                    System.out.print(n.val+",");
                }
                System.out.println();
            }
            root.next = null;
            recurConnect(root.left,level+1,list);
            recurConnect(root.right,level+1,list);
        }
    }

    public static void main(String[] args) {
        Node leaf1 = new Node();
        leaf1.val = 4;
        Node leaf2 = new Node();
        leaf2.val = 5;
        Node leaf3 = new Node();
        leaf3.val = 6;
        Node leaf4 = new Node();
        leaf4.val = 7;
        Node leaf5 = new Node(2,leaf1,leaf2,null);
        Node leaf6 = new Node(3,leaf3,leaf4,null);
        Node leaf7 = new Node(1,leaf5,leaf6,null);
        PopulatingNextRightPointersEachNode populatingNextRightPointersEachNode = new PopulatingNextRightPointersEachNode();
        populatingNextRightPointersEachNode.connect(leaf7);
    }
}
