class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         // Create adjacency list to store graph
         Map<Integer,List<int[]>> graph=new HashMap<>();
        for(int[] time:times)
        {
            int u=time[0],v=time[1],w=time[2];
            graph.computeIfAbsent(u,x -> new ArrayList<>()).add(new int[]{v,w});
        }
        // Min-heap priority queue (time, node)
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,k});  // Start from node k with time 0

        // Map to store minimum time to reach each node
        Map<Integer,Integer> dist=new HashMap<>();

        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int time=curr[0];
            int node=curr[1];

            if(dist.containsKey(node)) continue;

            dist.put(node,time);

            if(graph.containsKey(node))
            {
                for(int[] edge:graph.get(node))
                {
                    int nextnode=edge[0];
                    int weight=edge[1];

                    if(!dist.containsKey(nextnode))
                    {
                        pq.add(new int[]{time+weight,nextnode});
                    }
                }
            }
            
        }
        // If not all nodes are reached
        if(dist.size()!=n) return -1;

        // Return the maximum time to reach any node
        return Collections.max(dist.values());
    }
}
