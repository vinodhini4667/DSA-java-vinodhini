class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int result=0;
        int[][] height=new int[m][n];

// Step 1: Build height matrix
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    height[i][j]=0;
                }
                else
                {
                    height[i][j]=(i==0)? 1: height[i-1][j]+1;
                }
            }
        }
        // Step 2: For each row, use histogram trick
        for(int i=0;i<m;i++)
        {
            result+=countrow(height[i]);
        }
        return result;
    }

    public int countrow(int[] row)
    {
        Stack<Integer> stack=new Stack<>();
        int sum[]=new int[row.length];
        int res=0;

        for(int j=0;j<row.length;j++)
        {
            while(!stack.isEmpty() && row[stack.peek()]>=row[j])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                int prev=stack.peek();
                sum[j]=sum[prev]+row[j]*(j-prev);
            }
            else
            {
                sum[j]=row[j]*(j+1);
            }
            stack.push(j);
            res+=sum[j];

        }
        return res;
    }
    
}
