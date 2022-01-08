import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner ;
import java.util.HashSet;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoTeamsComposing
{
    public static void main(String[] args) {
        FastReader sc= new FastReader();
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] =  new int [n];
            int p = 1000000;
            int freq[] = new int[p];
            int maxfreq = 0;
            HashSet <Integer> hs = new HashSet <Integer> ();
            int dif = 0;
            for(int i =0 ;i<n;i++)
            {
                a[i] = sc.nextInt();
                freq[a[i]]++;
                if(freq[a[i]]>maxfreq)
                    maxfreq = freq[a[i]];
                hs.add(a[i]);

            }

            if(n>1)
            {


                if(hs.size()==maxfreq) {

                    System.out.println(maxfreq - 1);
                }else {
                    System.out.println(Math.min(hs.size(), maxfreq));
                }
            }
            else
                System.out.println(0);


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
