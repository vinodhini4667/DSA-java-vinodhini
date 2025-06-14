class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length==0)
        return "";

        String prefix=strs[0];

        for(int i=0;i<strs.length;i++)
        {
            while(strs[i].indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);
            
                 if(prefix.isEmpty())
                      return "";  
            }   
        }
        return prefix;
    }
}
class main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++)
        {
            str[i]=sc.nextLine();
        }
        Solution sol=new Solution();
        System.out.println(sol.longestCommonPrefix(str));
    }
}
