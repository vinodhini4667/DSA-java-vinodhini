class Solution {
    public String longestPalindrome(String s) {
        String longest="";
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                String substr=s.substring(i,j+1);
                if(ispalindrome(substr) && substr.length()>longest.length())
                {
                    longest=substr;
                }
            }
        }
        return longest;
        
    }

    public static boolean ispalindrome(String s)
    {
        int left=0,right=s.length()-1;
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Solution sol=new Solution();
        System.out.println(sol.longestPalindrome(str));
    }
}
