import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ZeroRemainderArray
{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            Hashtable <Integer, Integer> ht = new Hashtable<>();

            int count =0;

            for(int i =0;i<n;i++)
            {
                a[i] = sc.nextInt();
                int m = a[i]%k;
                if(m!=0)
                {
                    count ++;
                    int q = k - m;
                    int cp = ht.containsKey(q) ? ht.get(q) : 0;
                    ht.put(q, cp + 1);
                }
            }
//            System.out.println(ht);

            long ans = 0l;
            while(count>0)
            {
                int q =(int)( ans % k);
                if(q!=0)
                {
                    int cp = ht.containsKey(q) ? ht.get(q) : 0;
                    if (cp>0)
                    {
                        cp--;
                        count--;
                        ht.put(q, cp);
                    }
                }
                ans++;
            }
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
