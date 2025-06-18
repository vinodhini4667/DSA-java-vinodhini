class Solution {
    public boolean validPalindrome(String s) 
    {
        int left=0,right=s.length()-1;

        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return ispalindrome(s,left+1,right) || ispalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
    return true;
    }

    public boolean ispalindrome(String s,int left,int right)
    {
        while(left<right)
        {
            if(s.charAt(left++)!=s.charAt(right--))
            return false;
        }
        return true;

    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.validPalindrome(s));
    }
}
