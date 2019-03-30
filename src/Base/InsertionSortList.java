package Base;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode headPre = head;
        head=head.next;
        int i = 0;
        while(head!=null){
            ListNode temp = first.next;
            ListNode tempPre = first;
            while(temp.val<=head.val&&temp!=head){
                temp=temp.next;
                tempPre = tempPre.next;
            }
            if(temp!=head){
                headPre.next = head.next;
                tempPre.next = head;
                head.next = temp;
                head = headPre;
            }else{
                headPre = headPre.next;
            }
            head = head.next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        InsertionSortList insertionSortList = new InsertionSortList();
        CommonUtils.printListNode(insertionSortList.insertionSortList(listNode));
    }
}
