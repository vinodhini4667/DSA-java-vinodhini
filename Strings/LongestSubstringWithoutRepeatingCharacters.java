class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left=0,right=0,maxlength=0;

        while(right<s.length())
        {
            char ch=s.charAt(right);
            if(!set.contains(ch))
            {
                set.add(ch);
                maxlength=Math.max(maxlength,right-left+1);
                right++;
            }
            else
            {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
}
class main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Solution sol=new Solution();
        int result=sol.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}
