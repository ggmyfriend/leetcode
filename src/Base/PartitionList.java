package Base;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode trueHead = new ListNode(-1);
        ListNode cursor = trueHead;
        ListNode pre = new ListNode(-1);
        ListNode tempHead = pre;
        pre.next = head;
        while(head!=null){
            if(head.val<x){
                cursor.next = head;
                pre.next = head.next;
                cursor = cursor.next;
                cursor.next = null;
                head = pre.next;
            }else{
                pre=pre.next;
                head = head.next;
            }
        }
        cursor.next = tempHead.next;
        return trueHead.next;
    }
}
