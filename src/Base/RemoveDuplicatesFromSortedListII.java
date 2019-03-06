package Base;

import NewStart.RemoveNthNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = head;
        ListNode prePre = new ListNode(0);
        prePre.next = head;
        ListNode trueHead = prePre;
        head = head.next;
        boolean canChange = false;
        while(head!=null){
            if(head.val == pre.val){
                head = head.next;
                canChange = true;
            }
            else{
                if(canChange){
                    prePre.next = head;
                    pre=head;
                    canChange = false;
                    head = head.next;
                }else{
                   prePre = pre;
                   pre = head;
                   head = head.next;
                   canChange = false;
                }
            }
        }
        if(canChange){
            prePre.next = head;
        }
        return trueHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        ListNode head = removeDuplicatesFromSortedListII.deleteDuplicates(listNode);
        CommonUtils.printListNode(head);
    }
}
