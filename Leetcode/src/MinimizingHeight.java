import java.util.Arrays;
import java.util.Scanner;

public class MinimizingHeight
{
    static  int minVAL = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int k = sc.nextInt();

        Arrays.sort(ar);
        minVAL = ar[n-1] - ar[0];
        solve(0, ar,n, ar[0], ar[n-1],k);


        System.out.println(minVAL);
    }
    static void solve(int i , int ar[], int n, int min, int max, int k )
    {
        if(i>=n)
            return;

        int temp = ar[i];


        //NO CHANGE
        int p = max - min;
        if(p<minVAL)
            minVAL = p;
         solve(i+1, ar, n, min, max,k);
        for(int in: ar)
            System.out.print(in+"\t");
        System.out.println();



         //INCREASE BY K
        ar[i] = temp+k;
        if(max<ar[i])
            max = ar[i];

        p = max -  min;
        if(p<minVAL)
            minVAL = p;
        solve(i+1, ar, n, min, max,k);

        for(int in: ar)
            System.out.print(in+"\t");
        System.out.println();
        //decrease by k
        if(temp-k>=0) {
            ar[i] = temp - k;

            if (min > ar[i])
                min = ar[i];
            p = max - min;
            if (p < minVAL)
                minVAL = p;
            solve(i + 1, ar, n, min, max, k);

        }
//        ar[i] = temp;



        for(int in: ar)
            System.out.print(in+"\t");
        System.out.println();


    }
}
