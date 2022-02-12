import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CFA{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-->0)
        {
            int n = sc.nextInt();
            int ar[] = new int[n];
            int cpy []=  new int [n];

            for(int i  =0;i<n;i++) {
                ar[i] = sc.nextInt();
                cpy[i] =ar[i];
            }
            if(check(ar, cpy))
                System.out.println("NO");
            else System.out.println("YES");


        }
    }

    static  boolean check(int a1[], int b[])
    {
        Arrays.sort(b);
        for(int i  =0;i<a1.length;i++) {
            if(a1[i] != b[i])
                return  false;
        }
        return  true;


    }    static class FastReader
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