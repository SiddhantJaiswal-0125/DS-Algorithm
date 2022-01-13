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
          HashSet<Integer> hs = new HashSet<>();
          HashSet<Integer> done = new HashSet<>();
          for(int i =0;i<n;i++)
          {
              a[i] = sc.nextInt();
              hs.add(a[i]);
          }
          int count = 1;
          Arrays.sort(a);
          boolean notfound = true;
          notfound = solve2(a,n);
//          boolean b [] =new boolean[n];
//          int trailbount = 1;
//
//          while(trailbount<=n)
//          {
//              if(hs.contains(trailbount))
//              for(int i  =0;i<n;i++)
//              {
//                  if(b[i]==false && a[i] == trailbount) {
//                      b[i] = true;
//                      done.add(trailbount);
//
//                  }
//              }
//              trailbount++;
//
//          }
//
//          while(notfound && count <=n) {
//              System.out.println("NOT FOUND "+notfound);
//
//              if(done.contains(count))
//              {
//                  count++;
//                  continue;
//              }
//              notfound = false;
//
//              for(boolean bi : b)
//                  System.out.print(bi+"\t");
//              System.out.println();
//              for (int i = 0; i < n; i++) {
//                  System.out.println("FOR ELEMENT "+a[i] +" and count is "+count);
//                  if(b[i])
//                      continue;
//
//
//                  if (a[i] == count) {
//                      notfound = true;
//                      b[i] = true;
//                      count++;
//                      break;
//                  }
//                  else
//                  {
//                      int k = a[i];
//                      while(k>0  && k>=count)
//                      {
//                          if(k==count )
//                          {
//                              notfound = true;
//                              b[i] = true;
//                              count++;
//                              break;
//                          }
//                          else
//                              k/=2;
//                      }
//                  }
//
//              }
////              for(boolean bi : b)
////                  System.out.print(bi+"\t");
////              System.out.println();
//
//          }
          if(notfound)
              System.out.println("YES");
          else
              System.out.println("NO");




      }
    }

    static boolean solve2(int ar[], int n)
    {
        HashSet<Integer> counts = new HashSet<>();
        for(int i =1;i<=n;i++)
            counts.add(i);
        HashSet<Integer> elementsFound = new HashSet<>();
        for(int i = 0;i<n;i++)
        {
            int k = ar[i] ;
            while(k>0)
            {
                if(counts.contains(k) && elementsFound.contains(k) == false)
                {
                    elementsFound.add(k);
                    break;
                }
                k/=2;
            }
        }
        return  elementsFound.size() == n;
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
