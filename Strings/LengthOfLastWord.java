class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int  lastspace=s.lastIndexOf(' ');
        return s.length()-lastspace-1;
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Solution sol=new Solution();
        System.out.println(sol.lengthOfLastWord(str));
    }
}
