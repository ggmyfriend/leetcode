package Base;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersEachNodeII {
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
            }
            root.next = null;
            recurConnect(root.left,level+1,list);
            recurConnect(root.right,level+1,list);
        }
    }
}
