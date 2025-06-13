class Solution {
    public int firstUniqChar(String s) {
        int[] freq=new int[26];

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++)
        {
            if(freq[s.charAt(i)-'a']==1)
            return i;
        } 
        return -1;  
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Solution sol=new Solution();
        System.out.println(sol.firstUniqChar(s));
    }
}
