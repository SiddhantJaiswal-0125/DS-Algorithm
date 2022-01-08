import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
public class MiddleClass
{

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
	public static void main(String args[])
	{

		FastReader sc = new FastReader();
		int t = sc.nextInt();
		while(t-->0)
		{

			int n = sc.nextInt();
			int x = sc.nextInt();
			int ar[] = new int[n];
			for(int i =0;i<n;i++)
				ar[i] = sc.nextInt();


			Arrays.sort(ar);
			// int days = 0;
			int count = 1;
			long total = 0l;
			for(int i  =n-1;i>=0;i--)
			{
				total+=ar[i];


				if(total/count>=x)
				{
					count++;
				}
				else
					break;

			}

			System.out.println(count-1);




		}




	}
}