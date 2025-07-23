class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites)
        {
            int course=pre[0];
            int prerequisite=pre[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

         // Step 2: Topological sort using Queue
         Queue<Integer> queue=new LinkedList<>();
         for(int i=0;i<numCourses;i++)
         {
            if(indegree[i]==0)
            {
                queue.offer(i);
            }
         }

         int completedcourses=0;
         while(!queue.isEmpty())
         {
            int curr=queue.poll();
            completedcourses++;

            for(int neighbour:adj.get(curr))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                {
                    queue.offer(neighbour);
                }
            }
         }
         return completedcourses==numCourses; 
    }
}
