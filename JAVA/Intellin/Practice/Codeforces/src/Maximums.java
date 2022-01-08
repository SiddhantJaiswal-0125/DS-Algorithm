import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximums 
{
    static  FastReader  sc = new FastReader();
    public static void main(String[] args) {
       solve();

    }
    static void solve()
    {
        int n = sc.nextInt();

        int b[] = new int[n];
        int a[] = new int[n];
        int  max = 0;
        for(int i =0;i<n;i++)
        {
            b[i] = sc.nextInt();
            a[i] = b[i] + max;
            if(a[i]>max)
                 max = a[i];

        }
        for(int i : a)
        System.out.print(i+" ");
        System.out.println();
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
