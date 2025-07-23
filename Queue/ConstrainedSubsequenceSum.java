class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        Deque<Integer> deque=new LinkedList<>();

        dp[0]=nums[0];
        deque.offer(0);
        int result=dp[0];

        for(int i=1;i<n;i++)
        {
            while(!deque.isEmpty() && deque.peekFirst()< i-k)
            {
                deque.pollFirst();
            }
            dp[i]=nums[i]+Math.max(0,dp[deque.peekFirst()]);

            while(!deque.isEmpty() && dp[i]>=dp[deque.peekLast()])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
