package Base;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> lists;
    public List<List<Integer>> levelOrder(TreeNode root) {
        lists = new ArrayList<>();
        reLevelOrder(root,0);
        return lists;
    }
    public void reLevelOrder(TreeNode root,int level){
        if(root!=null) {
            List<Integer> list;

            if (lists.size() <= level) {
                list = new ArrayList<>();
                lists.add(list);

            } else {
                list = lists.get(level);
            }
            list.add(root.val);
            reLevelOrder(root.left,level+1);
            reLevelOrder(root.right,level+1);
        }
    }

}
