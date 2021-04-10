import java.util.*;
public class CountPalindromicSubsequences 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String str = sc.next();
        long ans = countPS(str);
        System.out.println(ans);
        // countPS(str);

        sc.close();


    }
    static long mod = 1000000007;
    static  long countPS(String str)
    {
        // Your code here
        int n = str.length();
        long  dp[][] = new long[n][n];
        for(int gap = 0;gap < n ;gap++)
        {
            for(int i =0, j = gap;j<n;i++, j++)
            {
                char c1 = str.charAt(i);
                char c2 = str.charAt(j);
                if(gap==0)
                dp[i][j] = 1*1l;
                else if(gap==1)
                dp[i][j] = c1==c2?3:2;
                else
                {
                    if(c1==c2)
                    dp[i][j] = ( ( dp[i+1][j] + 1 ) %mod + dp[i][j-1] %mod )% mod;


                    // add(add(,1),dp[i][j-1]);
                  else
                    dp[i][j] =  ((dp[i][j-1] % mod +  dp[i+1][j] %mod) -   dp[i+1][j-1]) %mod;
                    
                    // sub(add( dp[i][j-1],dp[i+1][j] ),    dp[i+1][j-1]);
              
                   
                }

            }
        }




        return dp[0][n-1];

        
    }
  
    static long sub (long a, long b)
    {
        return (a%mod - b%mod)%mod;
    }

    static long add (long a, long b)
    {
        return (a%mod + b%mod)%mod;
    }
    



    static void display(long dp[][],int n, int m )
    {
        for(int i  = 0;i<n;i++)
        {
            for(int j =0;j<m;j++)
        {
            System.out.print(dp[i][j] + " ");
        }
        System.out.println();
    }
    }
    
}
