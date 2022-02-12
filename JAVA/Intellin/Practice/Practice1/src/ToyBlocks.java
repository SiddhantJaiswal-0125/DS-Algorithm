import java.util.Scanner;

public class ToyBlocks
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int  n =sc.nextInt();
            long a[] = new long[n];
            long sum = 0l;
            long max = Long.MIN_VALUE;

            for(int i =0 ;i<n;i++)
            {
                a[i] = sc.nextInt();
                sum+=a[i];
                if(a[i]>max)
                    max = a[i];
            }
//            System.out.println("MAX "+max);
//            System.out.println("SUM "+sum);
            long req = 0l;
            req =(long)Math.ceil((sum)/(double)(n-1));
//            System.out.println("REQ "+req);
            long extra = req *(n-1);
            if(req < max)
                extra = max *(n-1);
            System.out.println(extra-sum);












        }
    }
}
