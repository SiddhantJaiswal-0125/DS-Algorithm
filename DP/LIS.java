import java.util.*;
public class LIS 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];
        for( int i = 0;i<n;i++)
        input[i] = sc.nextInt();
        
        int ans = _lis(input,n);
        System.out.println("Ans " +ans);

        sc.close();

    }
    static int _lis(int a[], int n)
    {
        int out[]  = new int[n];
        out[0] = 1;
        for(int i =1;i<n;i++)
        {
            out[i] = 1;
            for(int  j =i-1;j>=0;j--)
            {
                if(a[j] < a[i])
                    out[i] = Math.max(out[j]+1, out[i]);
            }

        }
        int max = 0;
        for(int i :out)
            max = Math.max(i, max);

   return max;
 }
    
}
