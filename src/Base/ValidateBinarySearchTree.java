package Base;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        List<Integer> list = inorderTraversal(root);
        int pre = list.get(0);
        for(int i = 1;i<list.size();i++){
            if(list.get(i)<=pre){
                return false;
            }else{
                pre = list.get(i);
            }
        }
        return true;
    }
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
    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        System.out.println(validateBinarySearchTree.isValidBST(treeNode));
    }
}
