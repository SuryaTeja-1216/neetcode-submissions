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
        // using fast and slow pointers
        // if there is a cycle both the fast and slow pointers will meet a point
        // we will move both slow and fast pointers at their own pace slow one step and fast moves two step and see if the slow == fast return true else false

        if(head==null || head.next==null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow) return true;
            
        }

        return false;
    }
}

//time complexity 
/*
O(n) - if there is a cycle
O(n/2) - if there is no cycle
*/

//space complexity
/*
O(1)
*/
