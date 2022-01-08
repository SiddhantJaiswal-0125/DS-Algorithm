import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CFC {
    public static void main(String[] args) {
      FastReader sc = new FastReader();
      int test = sc.nextInt();
      while (test-->0)
      {

          int n= sc.nextInt();
          int a[] = new int[n];
          long sum =0l;
          for(int i =0;i<n;i++)
          {
              a[i] = sc.nextInt();
              sum+=a[i];
          }
          if(sum%2==0)
              System.out.println(1);
          else
              System.out.println(2);








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
