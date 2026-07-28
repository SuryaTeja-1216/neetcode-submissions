/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // reverse a linked list using brute force stack 

        if(head==null || head.next == null) return head;
        Stack<ListNode> linkedListStack = new Stack<>();

        ListNode temp = head;

        while(temp!=null){
            linkedListStack.push(temp);
            temp = temp.next;
        }

        
        ListNode newHead = linkedListStack.pop();
        temp = newHead;
        while(!linkedListStack.isEmpty()){
            temp.next = linkedListStack.pop();
            temp = temp.next;
        }

        temp.next = null;

        return newHead;
    }
}
