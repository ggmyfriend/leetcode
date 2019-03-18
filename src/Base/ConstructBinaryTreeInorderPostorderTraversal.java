package Base;

import java.util.Arrays;

public class ConstructBinaryTreeInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recurBuildTree(postorder,inorder);
    }
    public TreeNode recurBuildTree(int[] postorder,int[] inorder){
        if(postorder.length>0) {
            TreeNode treeNode = new TreeNode(postorder[postorder.length-1]);
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == postorder[postorder.length-1]) {
                    index = i;
                    break;
                }
            }
            int[] postorder1 = Arrays.copyOfRange(postorder,index, postorder.length-1);
            int[] inorder1 = Arrays.copyOfRange(inorder, index+1, inorder.length);
            treeNode.right = recurBuildTree(postorder1, inorder1);
            int[] postorder2 = Arrays.copyOfRange(postorder, 0, index);
            int[] inorder2 = Arrays.copyOfRange(inorder, 0, index);
            treeNode.left = recurBuildTree(postorder2, inorder2);
            return treeNode;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreeInorderPostorderTraversal constructBinaryTreePreorderInorderTraversal = new ConstructBinaryTreeInorderPostorderTraversal();
        CommonUtils.printTreeNode(constructBinaryTreePreorderInorderTraversal.buildTree(new int[]{9},new int[]{9}));
    }
}
