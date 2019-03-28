package Base;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashMap = new HashSet<>();
        while(head!=null){
            if(hashMap.contains(head)){
                return head;
            }else{
                hashMap.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
