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
        // iterate through the array and find the length of the array and place the elements in array from the back
        // now traverse through the array and update the node.data


        if(head==null || head.next==null) return head;
        ListNode temp = head;

        int n=0;

        while(temp!=null){
            n++;
            temp = temp.next;
        }

        int[] listNodeData = new int[n];

        temp = head;
        for(int i=n-1;i>=0;i--){
            listNodeData[i] = temp.val;
            temp = temp.next;
        }

        temp = head;
        for(int i=0;i<n;i++){
            temp.val = listNodeData[i];
            temp = temp.next;
        }

        return head;
    }
}

// time complexity
/*
O(n)
*/

//space complexity 
/*
O(n)
*/
