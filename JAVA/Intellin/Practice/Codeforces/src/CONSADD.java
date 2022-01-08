import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CONSADD
{
    public static void main(String[] args)
    {
        FastReader sc = new FastReader() ;
        int t = sc.nextInt();
        while(t-->0)
        {
           int r = sc.nextInt();
           int c = sc.nextInt();
           int x = sc.nextInt();
           int a[][] = new int[r][c];
           int b[][] = new int[r][c];
           for(int i =0;i<r;i++)
               for(int j =0;j<c;j++)
                   a[i][j] = sc.nextInt();


            for(int i =0;i<r;i++)
                for(int j =0;j<c;j++)
                    b[i][j] = sc.nextInt();



                if(solve(a,b,r,c,x))
                    System.out.println("YES");
                else
                    System.out.println("NO");



        }
    }
    static  boolean solve(int a[][],int b[][], int r,int c, int x)
    {
        for(int i =0;i<r;i++)
        {
            for(int j = 0;j<c;j++)
            {
                if(a[i][j]==b[i][j])
                continue;
                else
                {
                    int p = b[i][j] - a[i][j];


                }


            }
        }

        return  true;
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
