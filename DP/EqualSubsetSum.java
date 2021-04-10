import java.util.*;
public class EqualSubsetSum 
{
    static boolean dp[][];
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]  = new int[n];
        for(int i =0;i<n;i++)
        a[i]  = sc.nextInt();

       if(solve(n,a)==1)System.out.println("YES");
       else
       System.out.println("NO");

    
        sc.close();
    }
    static int solve(int n , int a[])
    {
        int sum =0;
    
    
        for(int i=0;i<n;i++)
            sum+=a[i];
        
            if(sum%2!=0)
            return 0;
            else
            {
                sum/=2;
                
                  dp = new boolean[n+1][sum+1];
                  Arrays.sort(a);
                  

                  for(int  i =0;i<n+1;i++)
                  {
                      for(int j = 0;j<sum+1;j++)
                      {
                          if(j==0)
                            dp[i][j] = true;
                        }
                  }


                  for(int  i =1;i<n+1;i++)
                  {
                      for(int j =1;j<sum+1;j++)
                      {
                      
                        if(a[i-1]<=j)
                        dp[i][j] = dp[i][j-a[i-1]] || dp[i-1][j];
                        else
                        dp[i][j]  = dp[i-1][j];
                    }
                  }

                  if(dp[n][sum])
                  return 1;
                  else return 0;
                

            }

    
    // return 1;
    }


   

}
