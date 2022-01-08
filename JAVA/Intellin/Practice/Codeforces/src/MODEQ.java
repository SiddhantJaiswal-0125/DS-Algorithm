import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MODEQ {
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0)
        {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long ans = 0l;
            int  iter = 0;

            for(int i =1;i<=n;i++)
            {
                iter++;
                for(int j = i+1;j<=n;j++)
                {
                    iter++;
                    if(check(i, j, m)) {
                        System.out.println(i+" "+j);
                        ans++;
                    }
                }
            }

//            System.out.println("ITERATION "+iter);
            System.out.println(ans);
        }
    }
    static boolean check (long a, long b, long m)
    {
        return  ((m%a)%b) == ((m%b)%a);
    }








    //fast reader
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




