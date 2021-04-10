import java.util.*;
public class CoinChange
{
    static int dp[][]  ;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int coins[]  = new int[n];
        for(int i=0;i<n;i++)
            coins[i]  = sc.nextInt();
        dp = new int[n+1][sum+1];
        int ans = solve(coins,n,sum);

        System.out.println(ans);

    }

    static int solve(int coins[], int m, int n)
    {


        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (m <=0 && n >= 1)
            return 0;

        int first = solve(coins,n,n   - coins[m-1]);
        int second = solve(coins,m-1,n);
        return  first+second;
    }
    static int solveIterative(int coins[], int m , int n)
    {
        int table[] = new int[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for(int i =0 ;i<m;i++)
        {
            for(int j = coins[i];j<=n;j++)
                table[j] += table[j-coins[i]];

        }
        return  table[n];





    }
}
