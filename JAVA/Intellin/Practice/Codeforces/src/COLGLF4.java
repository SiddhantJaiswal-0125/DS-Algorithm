import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class COLGLF4
{
    static  int maxv =0;
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0)
        {
            int n,e,h,a,b,c;
            n = sc.nextInt();
            e = sc.nextInt();
            h = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            maxv = max(a,b,c);

            if(e/2>=n ||  h/3 >=n || (e>n && h >=n))
            {
                int ans = solve(n,e,h,a,b,c);
                System.out.println(ans);
            }
            else
                System.out.println(-1);

        }

    }


    static  int solve(int n, int e, int h, int a, int b, int c)
    {
        if(n==0)
            return  0;
        if(e<=0 || h<=0)
        {
            return Integer.MAX_VALUE - maxv;
        }

        return  min(a+solve(n-1,e-2,h,a,b,c),
                b+ solve(n-1,e,h-3,a,b,c), c+solve(n-1,e-1,h-1,a,b,c));


    }







    static  int min (int a, int b, int c)
    {
        return  Math.min(a, Math.min(b,c));
    }
    static  int max (int a, int b, int c)
    {
        return  Math.max(a, Math.max(b,c));
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
