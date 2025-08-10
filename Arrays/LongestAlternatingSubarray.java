class Solution {
    public int alternatingSubarray(int[] nums) {
        int n=nums.length;
        int maxlen=-1;

        for(int i=0;i<n-1;i++)
        {
            if(nums[i+1]-nums[i]==1)
            {
                int len=2;
                int expecteddiff=-1;
                for(int j=i+1;j<n-1;j++)
                {
                    if(nums[j+1]-nums[j]==expecteddiff)
                    {
                        len++;
                        expecteddiff*=-1;
                    }
                    else
                    {
                        break;
                    }

                }
                maxlen=Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}
