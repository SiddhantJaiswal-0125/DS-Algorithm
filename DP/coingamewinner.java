import java.util.Scanner;

public class coingamewinner 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(solve(n,x,y))
        System.out.println('A');
        else
        System.out.println('B');
    }
    static boolean solve(int n, int x, int y)
    {
        boolean dp[] = new boolean[n+1];
        dp[0] = false ;
        dp[1] = true ;
        for(int i = 2;i<=n;i++)
        {
            if(i-1>=0 && !dp[i-1])
            dp[i] = true;
            else if(i-x>=0 && !dp[i-x])
            dp[i]  = true;
            else if (i-y>=0 && !dp[i-y])
            dp[i] = true;
            else
            dp[i] = false;

        }
        return dp[n];

    }

}
