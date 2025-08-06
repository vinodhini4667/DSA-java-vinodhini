class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1); //(mod value → earliest index)

        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            int mod=(k==0)? sum:sum%k;

            if(map.containsKey(mod))
            {
                if(i-map.get(mod) > 1)
                {
                    return true;
                }
            }
            else
            {
                map.put(mod,i);
            }
        }
        return false;
    }
}
