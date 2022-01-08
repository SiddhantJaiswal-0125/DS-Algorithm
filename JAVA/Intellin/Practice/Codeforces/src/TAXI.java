import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TAXI 
{
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int a[] = new int[n];
        int freq[] = new int[5];
        for(int  i =0;i<n;i++)
        {
            a[i] = sc.nextInt();
            freq[a[i]] ++;

        }

    int count = 0;
    count+=freq[4];
    count+=(freq[2]/2);
    freq[2]%=2;

    count+=freq[3];
    if(freq[2]>0)
    {
        count++;
        freq[2]--;
        if(freq[1]>=2)
            freq[1] -=2;
        else
        freq[1]--;  
    }
    if(freq[1]>0)
        {   
             freq[1] -= Math.min(freq[1],freq[3]);
             
            if(freq[1]>0)
            {
                
                count+=(int)Math.ceil(freq[1]/4.0);
            }
        
        }

        System.out.println(count);
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
