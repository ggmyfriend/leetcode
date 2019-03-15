package Base;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> lists;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        lists = new ArrayList<>();
        reLevelOrder(root,0,false);
        return lists;
    }
    public void reLevelOrder(TreeNode root,int level,boolean isReverse){
        if(root!=null) {
            List<Integer> list;

            if (lists.size() <= level) {
                list = new ArrayList<>();
                lists.add(list);
            } else {
                list = lists.get(level);
            }
            if(isReverse) {
                list.add(0,root.val);
            }else{
                list.add(root.val);
            }
            reLevelOrder(root.left,level+1,!isReverse);
            reLevelOrder(root.right,level+1,!isReverse);
        }
    }
}
