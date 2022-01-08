package d2x;

import java.util.Arrays;
import java.util.Scanner;

public class arrayModification
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] =  sc.nextInt();

        int k = sc.nextInt();
        int f = sc.nextInt();
        int ans[] = solve(ar, n, k,f);
        System.out.println("NEW RESULTANT ARRAY IS : ");
        int len =ans.length;
        System.out.println("LEN IS "+len);
        for(int i = 0 ;i<len;i++)
        {
            System.out.print(ans[i]+"\t");
        }
        System.out.println();
    }
    static int []  solve(int ar[], int n , int k, int f)
    {

        int sum = 0;
        int res[] = new int[n+k];

        for(int i  = 0;i<n;i++) {
            sum += ar[i];
            res[i] = ar[i];
        }


        int req = (f * (n+k)) - sum;

        System.out.println("REQ "+req);
        if(req<k  || req > 6*k)
            return new int[0];

        int rreq[] = new int [k];

        int p = req/k;

        Arrays.fill(rreq, p);
        if(req%k!=0)
        {
            int size = n+k -1;
            int dif = req %k;

            while(dif>0)
            {

                rreq[size]++;
                size--;
                dif--;


            }
        }



        for(int i  =0;i<k;i++)
            res[i+n] = rreq[i];
        return  res;






















    }
}
