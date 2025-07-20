class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack=new Stack<>();
        Stack<StringBuilder> stringstack=new Stack<>();
        StringBuilder current=new StringBuilder();
        int k=0;

        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                k=k*10+(ch-'0');
            }
            else if(ch=='[')
            {
                countstack.push(k);
                stringstack.push(current);
                current=new StringBuilder();
                k=0;
            }
            else if(ch==']')
            {
                StringBuilder prev=stringstack.pop();
                int count=countstack.pop();
                for(int i=0;i<count;i++)
                {
                    prev.append(current);
                }
                current=prev;
            }
            else
            {
                current.append(ch);
            }

        }
        return current.toString();
    }
}
