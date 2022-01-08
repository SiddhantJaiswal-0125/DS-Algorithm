import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SKIPSTATION
{

    static long solve(int S[], int sum)
    {

        long[] dptable = new long[sum+5];
        Arrays.fill(dptable, 0);   //O(n)
        dptable[0] = 1;


        for (int i=0; i<=sum; i++)
            for (int j=1; j<=3; j++)
            {
                if (i - j >= 0)
                    dptable[i] += dptable[i - j];
            }
        return dptable[sum];
    }
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int arr[] = {1,2,3};
        int test = sc.nextInt();
        while(test-->0)
        {

            int n = sc.nextInt();
            long ans2 = solve(arr,n+1);
            System.out.println(ans2);
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
