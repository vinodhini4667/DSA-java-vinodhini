class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];   // Define colors for nodes: 0 = unvisited, 1 = visiting, 2 = safe
        List<Integer> safenodes=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(issafe(i,graph,color))
            {
                safenodes.add(i);
            }
        }
        return safenodes;
    }

    public boolean issafe(int node,int[][] graph,int[] color)
    {
       if(color[node]>0)
       {
        return color[node]==2;
       }
       color[node]=1;

       for(int neighbour:graph[node])
       {
        if(color[neighbour]==2)
        {
            continue;
        }
        if(color[neighbour]==1 ||  !issafe(neighbour,graph,color))
        {
            return false;
        }
       }
       color[node]=2;
       return true;

    }
}
