package Base;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return recurSortedListToBst(list);
    }
    public TreeNode recurSortedListToBst(List<Integer> list){
        if(list.size()!=0){
            TreeNode root = new TreeNode(list.get(list.size()/2));
            root.left = recurSortedListToBst(list.subList(0,list.size()/2));
            root.right = recurSortedListToBst(list.subList((list.size()/2)+1,list.size()));
            return root;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        ConvertSortedListBinarySearchTree convertSortedListBinarySearchTree = new ConvertSortedListBinarySearchTree();
        CommonUtils.printTreeNode(convertSortedListBinarySearchTree.sortedListToBST(head));
    }
}
