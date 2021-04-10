import java.util.*;

// import jdk.internal.org.objectweb.asm.tree.analysis.SourceValue;

public class thief 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]  = new int[n];
        for(int i =0;i<n;i++)
             a[i] = sc.nextInt();
        int ans = solve(a,n);
        t = new int[n+5];
        Arrays.fill(t, -1);
        // System.out.println(ans);
        System.out.println(solveDp(a,0,n));

    }
    static int t[];
    static int solve(int arr[], int  n)
    {
        int sum1 = arr[0];
        int sum2 = 0;
        int result;
        for (int i = 1; i < n; i++){
            result = (sum1 > sum2) ? sum1 : sum2;
            sum1 = sum2 + arr[i];
            sum2 = result;
        }
        return ((sum1 > sum2) ? sum1 : sum2);
    }

  
    static int solveDp(int a[], int i, int n)
    {
        if(i>=n)
            return 0;

        if(t[i+2]==-1)
            t[i+2] = solveDp(a, i+2, n);
        if(t[i+1]==-1)
        t[i+1] =     solveDp(a,i+1,n);
        return Math.max(a[i]+ t[i+2],t[i+1] );




    }


}