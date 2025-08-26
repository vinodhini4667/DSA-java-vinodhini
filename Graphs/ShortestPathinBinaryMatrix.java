class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        grid[0][0]=1;

        while(!queue.isEmpty())
        {
            int[] cell=queue.poll();
            int r=cell[0];
            int c=cell[1];
            int dist=grid[r][c];

            if(r==n-1 && c==n-1)
            {
                return dist;
            }

            for(int[] d: directions)
            {
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0)
                {
                    grid[nr][nc]=dist+1;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return -1;
    }
}
