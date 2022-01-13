import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CFA{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            boolean res = false;

            //CASE 1
            int dif = c - b;
            int want = b - dif;
            if(want%a == 0 && want >0)
            {
              res = true;
            }
            if(res==false)
            {

                //CASE 2
                dif = b - a;

                want = b + dif;
                if(want%c == 0 && want >0)
                {
                    res = true;
                }
            }
            if(res == false)
            {
                //CASE 3
                double  x = (c + a) /2.0;
                if((c+a) %2==0 )
                {
                    if(x%b == 0 && x >0)
                        res = true;
                }



            }

            if(res)
                System.out.println("YES");
            else
                System.out.println("NO");
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