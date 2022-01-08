import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

 class CFDIV2D{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0) {
            int n = sc.nextInt();
            long a[] = new long[n];
            int k = sc.nextInt();
                long divi = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if(a[i]%k==0)
                {
                    divi++;
                }
                else
                {
                    for(int j=0;j<20;j++)
                    {
                        a[i] +=a[i];
                        if(a[i]%k==0)
                        {
                            divi++;
                            break;
                        }
                    }
                }

            }


                if (divi == n)
                    System.out.println("YES");
                else System.out.println("NO");



            // method to print the divisors
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
