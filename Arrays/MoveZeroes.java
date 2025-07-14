class Solution {
    public void moveZeroes(int[] nums) {
        int lastnonzeroIndex=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[lastnonzeroIndex]=nums[i];
                lastnonzeroIndex++;
            }
        }

        while(lastnonzeroIndex<nums.length)
        {
            nums[lastnonzeroIndex]=0;
            lastnonzeroIndex++;
        }
        
    }
}
