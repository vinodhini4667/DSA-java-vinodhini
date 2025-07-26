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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null,curr=slow.next;
        slow.next=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode first=head,second=prev;
        while(second!=null)
        {
            ListNode tmp1=first.next;
            ListNode tmp2=second.next;

            first.next=second;
            second.next=tmp1;

            first=tmp1;
            second=tmp2;

        }
    }
        public static ListNode createlist(int[] arr)
        {
            ListNode head=new ListNode(arr[0]);
            ListNode current=head;
            for(int i=1;i<arr.length;i++)
            {
                current.next=new ListNode(arr[i]);
                current=current.next;
            }
            return head;
        }
        public static void printlist(ListNode head)
        {
            while(head!=null)
            {
                System.out.println(head.val+" ");
                head=head.next;
            }
        }
    
}
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        ListNode head=sol.createlist(arr);
        sol.reorderList(head);
        sol.printlist(head);

    }

}
