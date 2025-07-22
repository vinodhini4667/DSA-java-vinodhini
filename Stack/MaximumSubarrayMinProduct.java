class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        long[] prefix=new long[n+1];
        Stack<Integer> stack=new Stack<>();
        long maxproduct=0;
        int mod=(int)1e9+7;

        // Step 1: Compute prefix sum
        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+nums[i];
        }
        // Step 2: Monotonic Stack to find max min-product
        for(int i=0;i<=n;i++)
        {
            while(!stack.isEmpty() && (i==n || nums[i]<nums[stack.peek()]))
            {
                int minindex=stack.pop();
                int left=stack.isEmpty()? 0:stack.peek()+1;
                int right=i;
                long totalsum=prefix[right]-prefix[left];
                maxproduct=Math.max(maxproduct,totalsum*nums[minindex]);
            }
            stack.push(i);
        }
        return (int)(maxproduct % mod);
    }
}
