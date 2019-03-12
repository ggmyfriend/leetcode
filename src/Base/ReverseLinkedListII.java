package Base;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode afterM = new ListNode(-1);
        afterM.next = null;
        ListNode indexM = tempHead;
        for(int i = 1;i<m;i++){
            head = head.next;
            indexM = indexM.next;
        }
        ListNode middleEnd = head;
        for(int i = m;i<=n;i++){
            ListNode temp = head;
            head = head.next;
            temp.next = afterM.next;
            afterM.next = temp;
        }
        indexM.next = afterM.next;
        middleEnd.next = head;
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        CommonUtils.printListNode(reverseLinkedListII.reverseBetween(head,2,4));
    }
}
