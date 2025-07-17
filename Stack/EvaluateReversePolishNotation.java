class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            String token=tokens[i];
            if(token.equals("+")|| token.equals("-")|| token.equals("*") || token.equals("/"))
            {
               String operator=token;
               int b=stack.pop();
               int a=stack.pop();
               int result=0;

               switch(operator)
               {
                case "+":
                result=a+b;
                break;

                case "-":
                result=a-b;
                break;

                case "*":
                result=a*b;
                break;

                case "/":
                result=a/b;
                break;
               }
               stack.push(result);
            }
            else
            {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
