    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class CFB {

        public static void main(String[] args) {

            FastReader sc = new FastReader();
            int t = sc.nextInt();
            while (t-->0) {
                int n = sc.nextInt();
                int ar[]= new int[n];

                for(int i = 0;i<n;i++) {
                    ar[i] = sc.nextInt();
                }
              long ans = solve(ar,n);
                System.out.println(ans);
            }

        }

        static long solve(int ar[], int n)
        {
            long max = 0l;
            for(int i =0;i<n;i++)
            {
                long sum = 0;
                for(int j = i;j<n;j++)
                {
                    sum+= mex(ar[j]);
                    max += j-i+1+sum;
                }
            }
            return  max;
        }
        static  int mex(int a)
        {
            if(a==0)
                return  1;
            else
                return  0;
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
                    catch (IOException  e)
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
