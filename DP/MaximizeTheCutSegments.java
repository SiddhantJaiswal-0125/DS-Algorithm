import java.util.*;
public class MaximizeTheCutSegments 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x,y,z;
        x= sc.nextInt();
        y= sc.nextInt();
        z = sc.nextInt();


        int ans = solve(n,x,y,z);
        System.out.println(ans);


        // int ans2 = solverec(n,x,y,z);
        // System.out.println(ans2);
        sc.close();

    }
    static int solverec(int n , int x, int y, int z)
    {
        if(n<0)
        return -1;
        if(n==0)
        return 0;
        return max3(solverec(n-x, x, y, z), solverec(n-y, x, y, z), solverec(n-z, x, y, z))+1;



    }
    static int max3 (int a, int b, int c)
    {
        return Math.max(a, Math.max(b, c));
    }
    static int solve(int n, int x, int y, int z)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i =0;i<=n;i++)
        {
            if(dp[i]==-1)
            continue;
            if(i+x<=n)
            dp[i+x] = Math.max(dp[i+x], dp[i]+1);
            if(i+y<=n)
            dp[i+y] = Math.max(dp[i+y], dp[i]+1);
            if(i+z<=n)
            dp[i+z] = Math.max(dp[i+z], dp[i]+1);
            


        }
            if(dp[n]==-1)
            return 0;

        return dp[n];
    }
    
}
