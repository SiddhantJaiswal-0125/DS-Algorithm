import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CFDIV2B {


    static void solution(int n,int p[],int k  )
    {

        long var =p[0]*1l;

        long ans = 0L;
        for ( int i=1; i<n; i++ )
        {
            if ( p[i]*100L>var*k )
            {
                long sa = p[i]*100L-(var*k);
                long ans1 = sa/k;
                if ( sa%k>0 ) {
                    ans1++;
                }
                ans += ans1;
                var += (p[i]+ans1);
            } else {
                var += p[i];
            }
        }

        System.out.println(ans);

    }
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p[] = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = sc.nextInt();
            solution(n, p, k);


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
