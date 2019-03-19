package Base;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> lists;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recurPathSum(root,sum,list);
        return lists;
    }
    public void recurPathSum(TreeNode root,int sum,List<Integer> list){
        if(root == null){
            return;
        }else{
            list.add(root.val);
            sum -= root.val;
            if(root.left!=null||root.right!=null) {
                this.recurPathSum(root.left, sum, list);
                this.recurPathSum(root.right, sum, list);
            }else{
                if(sum==0){
                    lists.add(new ArrayList<>(list));
                }
            }
            list.remove(list.lastIndexOf(root.val));
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

    }
}
