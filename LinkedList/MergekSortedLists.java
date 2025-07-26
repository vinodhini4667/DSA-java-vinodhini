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
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap based on node values
        PriorityQueue<ListNode> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.val));
        // Add the head of each list to the heap
        for(ListNode node:lists)
        {
            if(node!=null)
            {
                pq.add(node);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;

        while(!pq.isEmpty())
        {
            ListNode minnode=pq.poll();
            current.next=minnode;
            current=current.next;

            if(minnode.next!=null)
            {
                pq.add(minnode.next);
            }
        }
        
        return dummy.next;
    }

    public static ListNode createlist(int[] arr)
    {
        if(arr.length==0) return null;
        ListNode head=new ListNode(arr[0]);
        ListNode current=head;
        for(int i=1;i<arr.length;i++)
        {
            current.next=new ListNode(arr[i]);
            current=current.next;
        }
        return head;
    }

}
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Solution sol=new Solution();

        int k=sc.nextInt();
        ListNode[] lists=new ListNode[k];
        for(int i=0;i<k;i++)
        {
            int size=sc.nextInt();
            int[] temp=new int[size];
            for(int j=0;j<size;i++)
            {
                temp[j]=sc.nextInt();
            }
            lists[i]=sol.createlist(temp);
        }
        ListNode result=sol.mergeKLists(lists);
        while(result!=null)
        {
            System.out.println(result.val+" ");
            result=result.next;
        }

    }
}
