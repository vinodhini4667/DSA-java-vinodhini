class Solution {
    public int maxSubArray(int[] nums) {
        int maxsofar=nums[0];
        int MaxEndingHere=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            MaxEndingHere=Math.max(nums[i],MaxEndingHere+nums[i]);
            maxsofar=Math.max(maxsofar,MaxEndingHere);
        }
        return maxsofar;
    }
}
