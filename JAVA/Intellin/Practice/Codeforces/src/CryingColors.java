import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CryingColors {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int mat[][] = new int[3][3];
            mat[0][0] = sc.nextInt();
            mat[0][1] = sc.nextInt();
            mat[0][2] = sc.nextInt();

            mat[1][0] = sc.nextInt();
            mat[1][1] = sc.nextInt();
            mat[1][2] = sc.nextInt();

            mat[2][0] = sc.nextInt();
            mat[2][1] = sc.nextInt();
            mat[2][2] = sc.nextInt();

            if(mat[0][0]  == n && mat[1][1] == n && mat[2][2] == n)
                System.out.println(0);
            else if(mat[0][0]  == n || mat[1][1] == n || mat[2][2] == n)
            {
                int val = 0 ;
                if(mat[0][0] !=n)
                {
                    System.out.println(n-mat[0][0]);
                }
                else if(mat[1][1] !=n)
                {
                    System.out.println(n-mat[1][1]);
                }
                else
                {
                    System.out.println(n-mat[2][2]);
                }
            }
            else
                System.out.println(solve3(mat,n));


        }

    }
    static long solve3(int ar[][], int n)
    {
        long c1 = ar[1][0]+ar[2][0]+ar[2][1];
        long c2 = ar[0][1]+ar[0][2]+ar[1][2];
        return max(c1, c2);
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
