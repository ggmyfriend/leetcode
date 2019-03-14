package Base;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end){
        if(start > end){
            return null;
        }
        if(start == end){
            TreeNode treeNode = new TreeNode(start);
            List<TreeNode> list = new ArrayList<>();
            list.add(treeNode);
            return list;
        }else{
            List<TreeNode> list = new ArrayList<>();
            for(int i = start;i<=end;i++){
                List<TreeNode> leftList = generateTrees(start,i-1);
                List<TreeNode> rightList = generateTrees(i+1,end);
                if(leftList!=null&&rightList!=null) {
                    for (TreeNode left : leftList) {
                        for (TreeNode right : rightList) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                    }
                }else if(leftList!=null&&rightList==null){
                    for (TreeNode left : leftList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = null;
                        list.add(root);
                    }
                }else if(leftList==null&&rightList!=null){
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = null;
                        root.right = right;
                        list.add(root);
                    }
                }else{
                    TreeNode root = new TreeNode(i);
                    list.add(root);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        for(TreeNode treeNode: uniqueBinarySearchTreesII.generateTrees(0)){
            System.out.println("--------------");
            CommonUtils.printTreeNode(treeNode);
        }
    }
}
