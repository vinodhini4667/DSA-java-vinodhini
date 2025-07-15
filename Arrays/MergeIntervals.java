class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        List<int[]> merged=new ArrayList<>();

        for(int[] interval:intervals)
        {
            if(merged.isEmpty() || merged.get(merged.size()-1)[1]<interval[0])
            {
                merged.add(interval);
            }
            else
            {
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] intervals=new int[n][2];

        for(int i=0;i<n;i++)
        {
            intervals[i][0]=sc.nextInt();
            intervals[i][1]=sc.nextInt();
        }
        Solution sol=new Solution();
        int[][] result=sol.merge(intervals);

        for(int[] row:result)
        {
            System.out.println(row[0]+" "+row[1]);
        }
    }
}
