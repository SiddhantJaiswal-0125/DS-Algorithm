import java.util.Scanner;

public class RedandBlue
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i =0;i<n;i++)
                a[i] = sc.nextInt();
            int m = sc.nextInt();
            int b[] = new int[m];
            for(int i =0;i<m;i++)
                b[i] = sc.nextInt();
            long ans = maxvalue(a,n);
            ans+=maxvalue(b,m);
            System.out.println(ans);
        }
    }
    static  long maxvalue(int arr[],int size)
    {
        long maxtotal = 0l;
        long curval = 0;
        for(int i=0;i<size;i++)
        {
            curval+=arr[i];
            if(curval>maxtotal)
                maxtotal = curval;
        }
        if(curval>maxtotal)
            maxtotal = curval;

        return maxtotal;

    }
}
