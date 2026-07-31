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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();

        ListNode temp = head;

        while(temp!=null){
            if(visitedNodes.contains(temp)) return true;
            else{
                visitedNodes.add(temp);
            }
            temp = temp.next;
        }

        return false;
    }
}
