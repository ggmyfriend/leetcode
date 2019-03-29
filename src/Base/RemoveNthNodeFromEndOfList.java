package Base;

/**
 Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = null;
        ListNode l2 = head;
        int nowIndex = 0;
        while(l2!=null){
            if(nowIndex<=n){
                l2 = l2.next;
                if(nowIndex == n){
                    l1 = head;
                }
                nowIndex++;
            }else{
                l1=l1.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            head = head.next;
        }else{
            l2 = l1.next.next;
            l1.next = l2;
        }
        return head;
    }
}
