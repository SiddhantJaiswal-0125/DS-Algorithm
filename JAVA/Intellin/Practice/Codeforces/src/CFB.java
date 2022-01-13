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
                int min =  Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for(int i = 0;i<n;i++) {
                    ar[i] = sc.nextInt();
                    if(ar[i] >max)
                        max = ar[i];
                    if(ar[i]<min)
                        min = ar[i];
                }

                System.out.println(max - min);
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
