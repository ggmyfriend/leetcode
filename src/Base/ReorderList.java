package Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        int length = 0;
        if(head ==null){
            return;
        }else{
            while(head!=null){
                list.add(head);
                head = head.next;
                length++;
            }
            int pre = 0;
            int las = length - 1;
            ListNode preNode = list.get(0);
            while(pre<=las){
                if(pre != las){
                    preNode.next = list.get(pre);
                    preNode.next.next = list.get(las);
                    preNode = list.get(las);
                    preNode.next = null;
                }else{
                    preNode.next = list.get(pre);
                    preNode.next.next = null;
                }
                pre++;
                las--;
            }

        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(listNode);
        CommonUtils.printListNode(listNode);
    }
}
