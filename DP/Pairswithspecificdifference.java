import java.util.Arrays;

import java.util.Scanner;

public class Pairswithspecificdifference 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
       
        for(int i =0;i<n;i++)
         {  
              a[i] = sc.nextInt();
            }  
         int  k = sc.nextInt();
         Arrays.sort(a);
         int dp[] = new int[n];
         dp[0]  =0;
         for(int i =1;i<n;i++)
         {
             dp[i]  = dp[i-1];
             if(a[i]-a[i-1]<k)
             {
                 if(i>=2)
                 {
                     dp[i]  = Math.max(dp[i], dp[i-2]+a[i-1]+a[i]);
                }
                else
                dp[i] = Math.max(dp[i], a[i]+a[i-1]);
             }
         }
         System.out.println(dp[n-1]);


        sc.close();

    }
    
}
