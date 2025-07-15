class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freqmap=new HashMap<>();

        for(int num:nums)
        {
            freqmap.put(num,freqmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> maxheap=new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());

        maxheap.addAll(freqmap.entrySet());

        int[] result=new int[k];
        for(int i=0;i<k;i++)
        {
            result[i]=maxheap.poll().getKey();
        }
    return result;
    }
}
