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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode first=dummy;
        ListNode second=dummy;

        // Move first n+1 steps ahead so second points to node before the target
        for(int i=0;i<=n;i++)
        {
            first=first.next;
        }
        // Move first to the end, maintaining the gap
        while(first!=null)
        {
            first=first.next;
            second=second.next;
        }
        // Remove the nth node from end
        second.next=second.next.next;
        return dummy.next;
    }
}
