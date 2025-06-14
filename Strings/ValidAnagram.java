class Solution {
    public boolean isAnagram(String s, String t) {
       
        if(s.length()!=t.length())
        return false;
        
        int[] freq=new int[26];

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;      
        }

        for(int i=0;i<t.length();i++)
        {
            freq[t.charAt(i)-'a']--;      
        }

        for(int count:freq)
        {
            if(count!=0)
            return false;
        }
       return true;
    }
}

class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        Solution sol=new Solution();
        System.out.println(sol.isAnagram(s,t));
    }
}
