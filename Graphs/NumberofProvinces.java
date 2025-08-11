class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int provinces=0;
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(isConnected,visited,i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected,boolean[] visited,int city)
    {
        visited[city]=true;
        for(int i=0;i<isConnected.length;i++)
        {
            if(isConnected[city][i]==1 && !visited[i])
            {
                dfs(isConnected,visited,i);
            }
        }
    }

}
