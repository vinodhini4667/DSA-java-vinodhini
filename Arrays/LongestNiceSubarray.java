class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        int mask=0,left=0;

        for(int right=0;right<n;right++)
        {

         // If new number shares a bit, shrink window
            while ((mask & nums[right]) != 0) {
                mask ^= nums[left]; // remove nums[left] bits from mask
                left++;
            }

            // Add new number to mask
            mask |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
