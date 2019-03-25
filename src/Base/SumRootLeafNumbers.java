package Base;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNumbers {
    List<Integer> list;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        list = new ArrayList<>();
        recurSumNumbers(root,0);
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        return sum;
    }
    public void recurSumNumbers(TreeNode treeNode,int sum){
        if(treeNode.left==null&&treeNode.right==null){
            list.add(sum*10+treeNode.val);
        }else{
            sum = sum*10 + treeNode.val;
            if(treeNode.left!=null){
                recurSumNumbers(treeNode.left,sum);
            }
            if(treeNode.right!=null){
                recurSumNumbers(treeNode.right,sum);
            }
        }
    }

    public static void main(String[] args) {
        SumRootLeafNumbers sumRootLeafNumbers = new SumRootLeafNumbers();
        TreeNode treeNode = new TreeNode(4);
        treeNode.right = new TreeNode(0);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        System.out.println(sumRootLeafNumbers.sumNumbers(treeNode));
    }
}
