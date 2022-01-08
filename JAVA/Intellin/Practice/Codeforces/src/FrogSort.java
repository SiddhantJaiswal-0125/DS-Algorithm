import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FrogSort
{
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int index[] = new int[n+1];
            int w[] = new int[n];
            int l[] = new int[n];
            int lcopy[] = new int [n+1];

            for(int  i =0;i<n;i++)
            {
                w[i] = sc.nextInt();
                index[w[i]] = i+1;
            }
            for(int  i =0;i<n;i++)
            {
                l[i] = sc.nextInt();
                lcopy[w[i]]  = l[i];
            }

            long count = 0l;

            for(int  i =2; i<n+1;i++)
            {

                if(index[i] <= index[i-1])
                {
                    while(index[i] <=index[i-1])
                    {
                     count++;
                     index[i] += lcopy[i];
                    }
                }
            }

            System.out.println(count);

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
