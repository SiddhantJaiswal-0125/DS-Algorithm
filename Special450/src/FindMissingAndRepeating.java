import java.util.Scanner;

public class FindMissingAndRepeating
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++)
            a[i] = sc.nextInt();
        int ans [] = solve(a,n);

        for(int  i : ans)
            System.out.println(i);

    }

    static int [] solve(int a[], int n )
    {
        int ans [] = new int[2];
        int ind = 0;
        long sumcal = (n *1l* (n+1))/2;

        long sqsumcal = (n *1l* (n+1)*((2*n) +1))/6;


        long sum = 0l, sqsum = 0l;
        for(int i:a)
        {
            sum+=i;
            sqsum+= (i*i);
        }

        sumcal = sumcal- sum;

        sqsum = (sqsumcal-sqsum)/sumcal;
        int  x = (int)( sqsum+sumcal)/2;
        int y = (int)(x - sumcal);
        ans[1] = Math.abs(x);
        ans[0] = Math.abs(y);

return  ans;
    }
}
