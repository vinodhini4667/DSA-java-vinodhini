class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea=0;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int area=dfs(grid,i,j);
                    maxarea=Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
    }

    public int dfs(int[][] grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        {
            return 0;
        }

        grid[i][j]=0;
        int area=1;

        area+=dfs(grid,i+1,j);
        area+=dfs(grid,i-1,j);
        area+=dfs(grid,i,j+1);
        area+=dfs(grid,i,j-1);

        return area;
    }
}

public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] grid=new int[rows][cols];

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        Solution sol=new Solution();
        System.out.println(sol.maxAreaOfIsland(grid));
    }
}
