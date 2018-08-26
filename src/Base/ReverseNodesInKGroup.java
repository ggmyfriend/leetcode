package Base;
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int i = 1;
        ListNode h = new ListNode(0);
        ListNode tail = h;
        ListNode tempHead = new ListNode(0);
        while(head!=null){
            ListNode listNode = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = listNode;
            if(i == k){
                tail.next = tempHead.next;
                tempHead.next = null;
                i = 1;
                while(tail.next!=null) tail = tail.next;
            }else {
                i++;
            }
        }
        if(i!=1){
            tempHead = tempHead.next;
            while(tempHead!=null){
                ListNode listNode = tempHead.next;
                tempHead.next = tail.next;
                tail.next = tempHead;
                tempHead = listNode;

            }
        }
        return h.next;
    }
}
