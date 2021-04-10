import java.util.Scanner;

public class Maximumsumincreasingsubsequence
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++)
        a[i]  = sc.nextInt();
        int ans = solve(a,n);
        System.out.println(ans);

        sc.close();

    }
    static int solve(int a[], int n )
    {
        int dp[] = new int [n+1];

        dp[0] = a[0];
       

        for(int i =1;i<n;i++)
        {
            int maxtill =0;
            for(int j = 0;j<i;j++)
            {
                if(a[j]<a[i])
                {

                    maxtill = Math.max(dp[j],maxtill);  
                }
            }
            dp[i]  = maxtill+a[i];
        }


         

        int max = 0;
        for(int i :dp){
            System.out.print(i+" ");
        max = Math.max(i,max);
        }
        System.out.println();
        return max;
    }
    
}
