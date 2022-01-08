import java.util.*;

public class strangeparty
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k[] = new int[n];
            long c[] = new long[m];
            int xc;

            for (int i = 0;i<n;i++)
            {
                xc = sc.nextInt();
                k[i] = xc-1;
            }
            for (int i = 0;i<m;i++)
            {
                c[i] = sc.nextLong();
            }
            int ind = 0;
            long res = 0l;
            Arrays.sort(k);

            for(int i = n-1;i>=0;i--)
            {

                if(ind<k[i])
                {
                    res+=c[ind];
                    ind++;
                }
                else
                {

                res+=c[k[i]];
                }
            }
            System.out.println(res);

        }
    }
}
