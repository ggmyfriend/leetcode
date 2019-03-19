package Base;

public class FlattenBinaryTreeLinkedList {
    public void flatten(TreeNode root) {
        recurFlatten(root);
    }
    public TreeNode recurFlatten(TreeNode root){
        if(root==null) {
            return null;
        }else {
            TreeNode tempRootLeft = recurFlatten(root.left);
            root.left = null;
            TreeNode tempRootRight = recurFlatten(root.right);
            root.right = tempRootLeft;
            TreeNode tempLastLeft = root;
            while(tempLastLeft.right!=null){
                tempLastLeft = tempLastLeft.right;
            }
            tempLastLeft.right = tempRootRight;
            return root;
        }
    }
}
