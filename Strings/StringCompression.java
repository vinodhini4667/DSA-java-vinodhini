class Solution {
    public int compress(char[] chars) {
        int index=0;
        int i=0;

        while(i<chars.length)
        {
            char currentchar=chars[i];
            int count=0;

            while(i< chars.length && chars[i]==currentchar)
            {
                i++;
                count++;
            }
            chars[index++]=currentchar;

            if(count>1)
            {
                for(char c:String.valueOf(count).toCharArray())
                chars[index++]=c;
            }
        }
    return index;  
    }
}
