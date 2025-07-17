class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int n=heights.length;
        int maxarea=0;
        
        for(int i=0;i<=n;i++)
        {
            int currentheight=(i==n)? 0:heights[i];

            while(!stack.isEmpty() && currentheight<heights[stack.peek()])
            {
                int height=heights[stack.pop()];
                int width=stack.isEmpty() ? i:i-stack.peek()-1;
                 maxarea=Math.max(maxarea,height*width);
            }
            stack.push(i);
        }
        return maxarea;
    }
}
