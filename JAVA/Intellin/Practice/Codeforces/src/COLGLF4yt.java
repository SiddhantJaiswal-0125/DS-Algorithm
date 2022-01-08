import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

 class COLGLF4yt
{
    public static void main(String[] args)
    {
      FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0)
        {
            long n,e,h,a,b,c;
            n = sc.nextLong();
            e = sc.nextLong();
            h = sc.nextLong();
            a = sc.nextLong();
            b = sc.nextLong();
            c = sc.nextLong();

            long ans = solve(n,e,h,a,b,c);

            if(ans==Long.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(ans);
        }

    }
    static  long solve(long n, long e, long h, long a, long b,long c)
    {
        if(n<=0)
            return  0;

        long ans  = Long.MAX_VALUE;
//        System.out.println(ans);

        if(n<=e && n<=h)
            ans = Math.min(ans, n*c);
        if( 2*n <= e)
            ans = Math.min(ans, n*a);

        if( n*3 <=h)
            ans = Math.min(ans, n*b);





        long sub = (h-n)/2 ;
        if(sub>=1 && sub >= n-e)
        {

            if( (b-c) < 0 )
            {
                long  k = Math.min(n-1,sub );
                ans = Math.min(ans, ( (b-c)*k  +  n*c )) ;

            }
            else
            {
                long k   = Math.max(1,n-e);
                ans = Math.min(ans, (b-c)*k + n*c  );

            }
        }

        if((e-n)>=1 && (e-n)>= n-h)
        {


            if(a-c<0)
            {
                long k  = Math.min(n-1, e-n);
                ans = Math.min(ans, (a-c)*k + (n*c)  );
            }
            else
            {
                long k  = Math.max(1, n-h);
                ans = Math.min(ans, (a-c)*k + (n*c));
            }
        }

        if(e/2 >=1 && e/2 >= ((3*n-h+2)/3))
        {
            long x;
            if((a-b)<0)
            {
                x = Math.min(n-1, e/2);
                ans = Math.min(ans, (a-b)*x + n*b);

            }
            else
            {
               x = Math.max(1,( 3*n-h+2)/3);
               ans = Math.min(ans, (a-b)*x + n*b);
            }
        }
        if(e>=3 && h>=4 && n>=3)
            ans = Math.min(ans, a+b+c+solve(n-3, e-3,h-4,a,b,c));


        return  ans;
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
