import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CFC {
    public static void main(String[] args) {
      FastReader sc = new FastReader();
      int test = sc.nextInt();
      while (test-->0)
      {
          int n= sc.nextInt();
          int a[] = new int[n];

          for(int i  =0;i<n;i++)
              a[i] = sc.nextInt();
          if(isPossible(a))
          {
              long count = 0l;
              for(int i =0;i<n;i++)
              {
                  if(i==0 || i == n-1 || a[i] == 0)
                      continue;
                  else if(a[i] % 2!=0)
                   count++;

                  count+= a[i]/2;
              }
              System.out.println(count);
          }
          else
              System.out.println(-1);

      }
    }

    static  boolean isPossible(int ar[])
    {
        int odd = 0;
        int size = ar.length;

        for(int i = 0;i<size;i++ )
        {
            if(i==0 || i == size-1 || ar[i] == 0)
                continue;
            else if(ar[i]%2==0)
                return  true;
            else odd++;

        }
        if(odd==0)
            return  true;
        return  false;

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
