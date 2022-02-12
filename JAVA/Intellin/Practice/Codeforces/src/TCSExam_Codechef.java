import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TCSExam_Codechef
{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0)
        {
            int a1, b1,c1 , a2, b2 ,c2;

            a1= sc.nextInt();
            b1 = sc.nextInt();
            c1= sc.nextInt();

            a2 = sc.nextInt();
            b2 = sc.nextInt();
            c2 = sc.nextInt();

            int t1 = a1+b1+c1;
            int t2 = a2+b2+c2;
            if(t1>t2)
                System.out.println("Dragon");
            else if(t2>t2)
                System.out.println("Sloth");
            else
            {
                if(a1>a2)
                    System.out.println("Dragon");
                else if(a2>a1)
                    System.out.println("Sloth");
                else
                {
                    if(b1>b2)
                        System.out.println("Dragon");
                    else if(b2>b1)
                        System.out.println("Sloth");
                    else
                        System.out.println("Tie");
                }
            }
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
    static  int min(int a , int b)
    {
        return  a<b?a:b;
    }
    static int max(int a, int b)
    {
        return  a>b?a:b;
    }
    static  long min(long a , long b)
    {
        return  a<b?a:b;
    }
    static long max(long a, long b)
    {
        return  a>b?a:b;
    }
}
