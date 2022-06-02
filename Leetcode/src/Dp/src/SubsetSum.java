import java.util.Scanner;

public class SubsetSum
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] =  new int[n];
        for(int i = 0;i<n;i++)
            ar[i] = sc.nextInt();
        int tar = sc.nextInt();
        boolean ans = _canAchievetheTarget(ar, n, tar);
        System.out.println(ans);
    }
     static boolean _canAchievetheTarget(int ar[], int n, int tar)
    {
        boolean dp[][] = new boolean[n+1][tar+1];
        for(int i =0;i<n+1;i++)
        {
            for(int j = 0;j<tar+1;j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(i==0)
                    dp[i][j] = false;
                else if(j==0)
                    dp[i][j] = true;
                else
                {
                    if(dp[i-1][j])
                        dp[i][j]= true;
                    else if(j>=ar[i-1])
                    {
                        if(dp[i-1][j-ar[i-1]])
                            dp[i][j]= true;
                    }
                }

            }

        }
        return dp[n][tar];


    }
}
