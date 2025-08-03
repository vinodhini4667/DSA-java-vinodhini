class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
        return;

        grid[i][j]='0'; //mark visited

        dfs(grid,i+1,j); //down
        dfs(grid,i-1,j); //up
        dfs(grid,i,j+1); //right
        dfs(grid,i,j-1);

    }
}

public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        int rows=sc.nextInt();
        int cols=sc.nextInt();
        char[][] grid=new char[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                grid[i][j]=sc.next().charAt(0);
            }
        }
        Solution sol=new Solution();
        int result=sol.numIslands(grid);
        System.out.println(result);
    }
}
