class Solution {
    public String maskPII(String s) {
        if(s.contains("@"))
        {
            //email case
            s=s.toLowerCase();
            String[] parts=s.split("@");
            String name=parts[0];
            return name.charAt(0)+"*****"+name.charAt(name.length()-1)+"@"+parts[1];
        }
        else
        {
            //number case
            String digits=s.replaceAll("[^0-9]","");  // Remove all non-digits
            String local=digits.substring(digits.length()-4); //last 4 digits
            int countrycode=digits.length()-10;

            StringBuilder masked=new StringBuilder();
            if(countrycode>0)
            {
                masked.append("+");
                for(int i=0;i<countrycode;i++)
                {
                    masked.append("*");
                }
                masked.append("-");
            }

            masked.append("***-***-").append(local);
            return masked.toString();
        }

    }
}
