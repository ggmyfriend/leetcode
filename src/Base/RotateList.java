package Base;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode tempHead = head;
        ListNode tempLast = null;
        while(tempHead!=null){
            length++;
            tempLast = tempHead;
            tempHead = tempHead.next;
        }
        if(length==0){
            return head;
        }
        k = k % length;
        if (k==0){
            return head;
        }
        int index = 0;
        tempHead = head;
        ListNode trueLast = null;
        while(index!=(length - k)){
           index++;
           trueLast = tempHead;
           tempHead = tempHead.next;
        }
        tempLast.next = head;
        trueLast.next = null;
        return tempHead;
    }

}
