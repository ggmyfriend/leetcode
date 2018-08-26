package Base;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 * Example

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 使用这种方法是为了适应listnode很长的时候
         */
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        int carry = 0;
        while(l1!=null&&l2!=null){
            int sum = l1.val + l2.val +carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val +carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val +carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            l2 = l2.next;
        }
        /**
         * 当最后还有进位的时候需要再进
         */
        if(carry>0){
            listNode.next = new ListNode(carry);
        }
        return head.next;
    }
}
