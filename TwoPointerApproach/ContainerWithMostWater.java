class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxwater=0;

        while(left<right)
        {
            int width=right-left;
            int currentheight=Math.min(height[left],height[right]);
            int currentwater=width*currentheight;
            maxwater=Math.max(maxwater,currentwater);

            if(height[left]<height[right])
            {
                left++;
            } 
            else
            {
                right--;
            }
        }
        return maxwater;
    }
}
