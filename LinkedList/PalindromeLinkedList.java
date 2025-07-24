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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        // Step 1: Find the middle of the list
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        // Step 2: Reverse second half
        ListNode prev=null;
        while(slow!=null)
        {
            ListNode nextnode=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextnode;
        }
         // Step 3: Compare both halves
         ListNode left=head;
         ListNode right=prev;
         while(right!=null)
         {
            if(left.val!=right.val) return false;
            left=left.next;
            right=right.next;
         }
    return true;
    }
}
