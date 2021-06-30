package Arrays;

import java.util.*;
public class MissingNumber1
{
    public  static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = missingNumber(ar);
        System.out.println("ANSWER "+ans);
    }
    public static  int missingNumber(int[] nums) {
        long sum  =0;
        int size = nums.length;

        for(int  i :nums)
            sum+=i;

        return (int) (((size * (size+1))/2) - sum);
    }
}
