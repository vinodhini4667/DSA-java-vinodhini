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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null|| head.next==null || k==0) return head;

        // Step 1: Compute the length of the list
        ListNode curr=head;
        int len=1;
        while(curr.next!=null)
        {
            curr=curr.next;
            len++;
        }
        // Step 2: Make the list circular
        curr.next=head;
         // Step 3: Find the new tail and head
         k=k%len;
         int stepstonewtail=len-k;
         ListNode newtail=head;
         for(int i=1;i<stepstonewtail;i++)
         {
            newtail=newtail.next;
         }
         
         ListNode newhead=newtail.next;
         newtail.next=null;

         return newhead;
    }
}
