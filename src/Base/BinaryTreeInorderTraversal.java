package Base;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class BinaryTreeInorderTraversal {
    List<Integer> list ;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        recursionTree(root);
        return list;
    }
    public void recursionTree(TreeNode root){
        if(root==null){
            return;
        }else{
            if(root.left!=null){
                recursionTree(root.left);
            }
            list.add(root.val);
            if(root.right!=null) {
                recursionTree(root.right);
            }
        }
    }
}
