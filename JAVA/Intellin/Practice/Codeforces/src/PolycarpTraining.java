import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class PolycarpTraining
{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int ar[]= new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = solve(ar, n);
        System.out.println(ans);
    }
    static int solve(int ar[], int n)
    {
        Arrays.sort(ar);
        int k = 1;
        for(int i = 0;i<n;i++)
        {

                if(ar[i]>=k)
                    k++;

        }
        return k-1;
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}
