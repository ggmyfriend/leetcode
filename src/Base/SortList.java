package Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while(head!=null){
            listNodes.add(head);
            head = head.next;
        }
        Collections.sort(listNodes, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val>o2.val){
                    return 1;
                }else if(o1.val==o2.val){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        ListNode tempHead = new ListNode(-1);
        head = tempHead;
        for(ListNode listNode:listNodes){
            head.next = listNode;
            head = head.next;
        }
        head.next = null;
        return tempHead.next;
    }
}
