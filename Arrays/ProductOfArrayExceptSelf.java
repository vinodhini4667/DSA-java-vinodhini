class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] product=new int[n];
       
       //prefix product
        product[0]=1;
        for(int i=1;i<n;i++)
        {
            product[i]=product[i-1]*nums[i-1];
        }

        int suffix=1;
        for(int i=n-1;i>=0;i--)
        {
            product[i]=product[i]*suffix;
            suffix=suffix*nums[i];
        }
        return product;
        
    }
}
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];

        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        Solution sol=new Solution();
        int[] result=sol.productExceptSelf(nums);

        for(int num:result)
        {
            System.out.println(num+" ");
        }
    }

}
