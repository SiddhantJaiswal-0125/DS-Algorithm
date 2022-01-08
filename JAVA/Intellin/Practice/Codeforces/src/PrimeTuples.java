import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

 class PrimeTuples
{
    static  boolean iSprime[] ;
    static final int MAX_SIZE = 1000001;

    static Vector<Boolean> isprime = new Vector<>(MAX_SIZE);
    static Vector<Integer>prime = new Vector<>();
    static Vector<Integer>SPF = new Vector<>(MAX_SIZE);
    static void manipulated_seive(int N)
    {
        for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }
        isprime.set(0, false);
        isprime.set(1, false);
        for (int i=2; i<N ; i++)
        {
            if (isprime.get(i))
            {

                prime.add(i);

                SPF.set(i,i);
            }
            for (int j=0;
                 j < prime.size() &&
                         i*prime.get(j) < N && prime.get(j) <= SPF.get(i);
                 j++)
            {
                isprime.set(i*prime.get(j),false);
                SPF.set(i*prime.get(j),prime.get(j)) ;
            }
        }
        iSprime = new boolean[N+1];
        for (int i=0; i<prime.size() && prime.get(i) <= N ; i++) {
           iSprime[prime.get(i)] = true;
        }
    }







    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        int ten6  = 1000000;

        manipulated_seive(ten6);
        int ans[]  = new int[ten6+1];
        int count = 0;
        for(int i =5 ;i<=ten6;i++)
        {
            if(iSprime[i] && iSprime[i-2])
                count++;

            else
                ans[i] = count;
        }

        while(t-->0)
        {
            int n = sc.nextInt();
            System.out.println(ans[n]);

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
