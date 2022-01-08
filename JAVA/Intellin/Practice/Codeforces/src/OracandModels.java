import java.util.Arrays;
import java.util.Scanner;

public class OracandModels
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {

            int n = sc.nextInt();
            int a[] = new int[n+1];
            for(int i =1;i<=n;i++)
                a[i]  = sc.nextInt();
            int ans = solve(a,n+1);

            System.out.println(ans);
        }


    }

    static  int solve(int a[], int n)
    {
        int max = 0;
        int freq[] = new int[n];
        Arrays.fill(freq,1);
        for(int i =1;i<n;i++)
        {
            for(int j =i*2;j<n;j+=i)
            {

                if(a[j]>a[i])
                {

                    freq[j]= Math.max(freq[j],freq[i]+1);
                }
            }
        }

        for(int i =1;i<n;i++)
            max = Math.max(freq[i],max);
        return  max;
    }
}
