import java.util.Scanner;

public class Q1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int l[] = new int[q];
        int r [] = new int[q ];
        int x[] = new int[q];

        for(int  i= 0;i<q;i++)
        {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            x[i] = sc.nextInt();

        }



        long res [] = solve(ar,x,r,l);
        for(long ri:res)
            System.out.println(ri);



    }
    static  long[] solve(int A[], int X[], int R[], int L[])
    {

        int q = X.length;
        long ans [] = new long[q];

        int i  =0;
        while(i<q)
        {
            int l = L[i];
            int r = R[i];
            int x = X[i];
            long xor =0l;
            for(int ind = l-1 ; ind<r;ind++)
                xor +=  (x^ A[ind]);

            ans[i] = xor;
            i++;
        }

        return ans;
    }
}




//
//    long leftxor[] = new long[n];
//    long rightxor[] = new long[n];
//    long xor = 0l;
//
//
//        for(int i =0;i<n;i++)
//        {
//        xor = xor^ar[i];
//        leftxor[i] = xor;
//
//        }
//        xor = 0l;
//        for(int  i =n-1;i>=0;i--)
//        {
//        xor = xor^ar[i];
//        rightxor[i] = xor;
//
//        }
//        long totalxor = xor;
//
//
//
//
//
