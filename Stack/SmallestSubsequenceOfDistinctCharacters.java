class Solution {
    public String smallestSubsequence(String s) {
        int[] lastindex=new int[26];
        boolean[] seen=new boolean[26];
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            lastindex[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
             // If already in stack, skip
            if(seen[ch-'a'])
            continue;
            // Remove characters that are:
            // 1. Greater than current char
            // 2. Appear again later (based on lastIndex)
            while(!stack.isEmpty() && ch<stack.peek() && lastindex[stack.peek()-'a']>i)
            {
                char removed=stack.pop();
                seen[removed-'a']=false;
            }
            stack.push(ch);
            seen[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack)
        {
            sb.append(c);
        }
        return sb.toString();
    }
}
