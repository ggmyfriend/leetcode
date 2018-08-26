package Base;
/**
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = null;
        ListNode head1 = null;
        while(l1!=null&&l2!=null){
            if(head == null){
                if(l1.val<=l2.val){
                    head = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    head = new ListNode(l2.val);
                    l2 = l2.next;
                }
                head1 = head;
            }else{
                if(l1.val<=l2.val){
                    head1.next = new ListNode(l1.val);
                    l1 = l1.next;
                }else{
                    head1.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                head1 = head1.next;
            }
        }
        if(l2!=null){
            head1.next = l2;
        }
        if(l1!=null){
            head1.next = l1;
        }
        return head;
    }
}
