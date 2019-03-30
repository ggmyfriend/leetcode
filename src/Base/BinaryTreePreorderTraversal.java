package Base;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    List<Integer> list ;
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        recursionTree(root);
        return list;
    }
    public void recursionTree(TreeNode root){
        if(root==null){
            return;
        }else{
            list.add(root.val);
            if(root.left!=null){
                recursionTree(root.left);
            }
            if(root.right!=null) {
                recursionTree(root.right);
            }
        }
    }
}
