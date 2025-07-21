class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();

        for(String str:operations)
        {
            if(str.equals("C"))
            {
                stack.pop();
            }
            else if(str.equals("D"))
            {
                stack.push(2*stack.peek());
            }
            else if(str.equals("+"))
            {
                int top=stack.pop();
                int newtop=top+stack.peek();
                stack.push(top);
                stack.push(newtop);
            }
            else
            {
                stack.push(Integer.parseInt(str));
            }
        }
        int sum=0;
        for(int ch:stack)
        {
            sum+=ch;
        }
        return sum;
    }
}
