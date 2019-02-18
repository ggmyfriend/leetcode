package Base;

import javax.annotation.processing.SupportedSourceVersion;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode headest = new ListNode(0);
        headest.next = head;
        ListNode pre = head;
        ListNode las = head.next;
        head = headest;
        while(las!= null){
            pre.next = las.next;
            las.next = pre;
            head.next = las;
            if(pre.next==null){
                break;
            }else if(pre.next != null && pre.next.next==null){
                break;
            }else{
                head = pre;
                pre = pre.next;
                las = pre.next;
            }
        }
        return headest.next;
    }
    public static void main(String[] args){
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode listNode1 = swapNodesInPairs.swapPairs(listNode);
        while(listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}
