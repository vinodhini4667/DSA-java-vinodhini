class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
        return 0;

        int[] heights=new int[matrix[0].length];
        int maxarea=0;

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                {
                    heights[j]+=1;
                }
                else
                {
                    heights[j]=0;
                }
            }
            maxarea=Math.max(maxarea,longestrectanglearea(heights));
        }
       return maxarea; 
    }

public  int longestrectanglearea(int[] heights)
{
    Stack<Integer> stack=new Stack<>();
    int max=0;
    int n=heights.length;
    for(int i=0;i<=n;i++)
    {
        int h=(i==n)? 0:heights[i];
        while(!stack.isEmpty() && h< heights[stack.peek()])
        {
            int height=heights[stack.pop()];
            int width=stack.isEmpty() ? i:i-stack.peek()-1;
            max=Math.max(max,height*width);
        }
        stack.push(i);
    }
    return max;
}
}
