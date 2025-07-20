class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestsum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++)
        {
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(target-sum)<Math.abs(target-closestsum))
                {
                    closestsum=sum;
                }
                if(sum<target)
                {
                    left++;
                }
                else if(sum>target)
                {
                    right--;
                }
                else
                {
                    return target;
                }

            }

        }
       return closestsum; 
    }
}
