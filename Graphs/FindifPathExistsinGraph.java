class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //build adjacency list
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        return dfs(graph,source,destination,visited);
    
    }
    public boolean dfs(List<List<Integer>> graph,int node,int destination,boolean[] visited)
    {
        if(node==destination) return true;
        visited[node]=true;

        for(int neighbour:graph.get(node))
        {
            if(!visited[neighbour] && dfs(graph,neighbour,destination,visited))
            {
                return true;
            }
        }
        return false;
    }
}
