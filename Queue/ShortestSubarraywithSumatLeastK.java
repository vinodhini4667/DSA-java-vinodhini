class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] prefix=new long[n+1];
        // Step 1: Create prefix sum array
        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+nums[i];
        }
        int result=n+1;
        Deque<Integer> deq=new ArrayDeque<>();
        for(int i=0;i<prefix.length;i++)
        {
            // Step 2: Remove from front while valid subarray found
            while(!deq.isEmpty() && prefix[i]-prefix[deq.peekFirst()]>=k)
            {
                result=Math.min(result,i-deq.pollFirst());
            }
            while(!deq.isEmpty() && prefix[i]<=prefix[deq.peekLast()])
            {
                deq.pollLast();
            }
            // Step 4: Add current index to deque
            deq.offerLast(i);
        }
       return result<=n ? result:-1;
    }
}
