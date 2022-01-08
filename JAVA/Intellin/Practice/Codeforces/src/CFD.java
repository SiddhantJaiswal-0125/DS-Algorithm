import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CFD {


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0) {

            int n = sc.nextInt();
            long m = sc.nextLong();
            int a[] = new int[n];
            int b[] = new int[n];
            ArrayList<cp> c = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                c.add(new cp());
                c.get(i).a = a[i];


            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();

                c.get(i).b = b[i];


            }

            comImpl com = new comImpl();
            Collections.sort(c, com);
            int i = 0;
            long s = 0l;
            long cost =0;
            while (i < n && s < m)
            {}

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
 class cp  {
     int a, b;

 }



 class comImpl implements Comparator    <cp>
 {

     @Override
     public int compare(cp o1, cp o2) {
         return o1.b - o2.b;

     }
 }