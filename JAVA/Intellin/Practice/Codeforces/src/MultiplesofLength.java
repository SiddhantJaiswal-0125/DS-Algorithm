import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MultiplesofLength
{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
       int n = sc .nextInt();
       long  a[] = new long[n];
       for(int i=0;i<n;i++)
           a[i] = sc.nextLong();

       if(n==1)
       {
           System.out.println("1 1" );
           System.out.println(0);

           System.out.println("1 1" );
           System.out.println(0);
           System.out.println("1 1" );
           System.out.println((-1*a[0]));
       }
       else
           {
           System.out.println(1+ " "+1 );
           System.out.println((-1*a[0]));
           a[0] = 0;
           System.out.println(2+" "+n);
           long p = a[1]%n;
           long val = p *1l* (n-1);
           a[1] +=val;
           System.out.print(val);
           for(int i =2;i<n;i++)
           {

//                   System.out.print(" ");
                 p = a[i]%n;
                 val = p *1l* (n-1);
               a[i] +=val;
               System.out.print(" "+val);

           }
           System.out.println();

           System.out.println(1+" "+n);
           System.out.print(((-1)*a[0]));

           for(int  i =1;i<n;i++) {
//               if(i>0)


               System.out.print(" "+(-1*a[i]));
           }

           System.out.println();
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
