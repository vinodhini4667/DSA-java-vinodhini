class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int freshcount=0;

        // Step 1: Add all rotten oranges to queue & count fresh oranges
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c]==2)
                {
                      queue.add(new int[] {r,c});
                }
                else if(grid[r][c]==1)
                {
                    freshcount++;
                }
                
            }
        }

        if(freshcount==0) return 0;

        int minutes=-1;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty())
        {
             int size=queue.size();
             minutes++;

             for(int i=0;i<size;i++)
             {
                int[] pos=queue.poll();
                for(int[] d:directions)
                {
                    int nr=pos[0]+d[0];
                    int nc=pos[1]+d[1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        queue.add(new int[] {nr,nc});
                        freshcount--;
                    }
                }
             }

        }
        
        return (freshcount==0)? minutes:-1;
    }
}
