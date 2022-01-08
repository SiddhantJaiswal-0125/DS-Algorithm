import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MAXFUN
{
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            long a[]  = new long[n];
            for(int  i =0;i<n;i++)
                a[i] = sc.nextLong();
            Arrays.sort(a);


            long ans = 0l;
            int mid = (int)Math.ceil(n/2.0);
            ans += Math.abs(a[n-1] - a[0]);
            ans+= Math.abs(a[n-1] - a[mid]);
            ans+= Math.abs(a[0] - a[mid]);
            System.out.println(ans);

        }

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
