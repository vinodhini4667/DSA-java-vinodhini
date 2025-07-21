class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();

        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                stack.push(-1);// Use -1 as a marker for '('
            }
            else
            {
                int score=0;
                while(stack.peek()!=-1)
                {
                    score+=stack.pop();
                }
                stack.pop();// remove the -1 marker
                if(score==0)
                {
                    stack.push(1);
                }
                else
                {
                    stack.push(2*score);
                }
            }
        }  
        int total=0;
        while(!stack.isEmpty())
        {
            total+=stack.pop();
        }  
        return total;   
    }
}
