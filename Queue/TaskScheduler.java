class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task:tasks)
        {
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int maxfreq=freq[25]-1;
        int idleslots=maxfreq*n;

        for(int i=24;i>=0 && freq[i]>0 ;i--)
        {
            idleslots-=Math.min(freq[i],maxfreq);
        }
        return idleslots>0 ? idleslots+tasks.length : tasks.length;
    }
}
