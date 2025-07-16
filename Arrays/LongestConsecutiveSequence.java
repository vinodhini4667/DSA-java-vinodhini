class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }

        int longest=0;
        for(int num:set)
        {
            if(!set.contains(num-1))
            {
                int currentnum=num;
                int streak=1;

                while(set.contains(currentnum+1))
                {
                    currentnum++;
                    streak++;
                }
                longest=Math.max(longest,streak);
            }
        }
        return longest;
    }
}
