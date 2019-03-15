package Base;

import java.util.Arrays;

public class ConstructBinaryTreePreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recurBuildTree(preorder,inorder);
    }
    public TreeNode recurBuildTree(int[] preorder,int[] inorder){
        if(preorder.length>0) {
            TreeNode treeNode = new TreeNode(preorder[0]);
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    index = i;
                    break;
                }
            }
            int[] preorder1 = Arrays.copyOfRange(preorder, 1, index + 1);
            int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
            CommonUtils.printArrays(preorder1);
            CommonUtils.printArrays(inorder1);
            treeNode.left = recurBuildTree(preorder1, inorder1);
            int[] preorder2 = Arrays.copyOfRange(preorder, index + 1, preorder.length);
            int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            CommonUtils.printArrays(preorder2);
            CommonUtils.printArrays(inorder2);
            treeNode.right = recurBuildTree(preorder2, inorder2);
            return treeNode;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorderTraversal constructBinaryTreePreorderInorderTraversal = new ConstructBinaryTreePreorderInorderTraversal();
        CommonUtils.printTreeNode(constructBinaryTreePreorderInorderTraversal.buildTree(new int[]{1},new int[]{1}));
    }
}
