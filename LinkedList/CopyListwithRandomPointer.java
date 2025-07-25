/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}*/


class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // Step 1: Insert copied nodes after original nodes
        Node curr=head;
        while(curr!=null)
        {
            Node newnode=new Node(curr.val);
            newnode.next=curr.next;
            curr.next=newnode;
            curr=newnode.next;
        }
        // Step 2: Copy random pointers
        curr=head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        // Step 3: Separate original and copied lists
        Node dummy=new Node(0);
        Node copy=dummy;
        curr=head;
        while(curr!=null)
        {
            copy.next=curr.next;
            curr.next=curr.next.next;

            copy=copy.next;
            curr=curr.next;

        }
        return dummy.next;
    }
}
