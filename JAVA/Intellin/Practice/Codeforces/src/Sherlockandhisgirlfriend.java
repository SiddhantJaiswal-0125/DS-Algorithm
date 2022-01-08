

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sherlockandhisgirlfriend 
{

   static  void sieveOfEratosthenes(int n)
    {
        // Create a boolean array 
        // "prime[0..n]" and
        // initialize all entries 
        // it as true. A value in
        // prime[i] will finally be 
        // false if i is Not a
        // prime, else true.
        if(n>3)
        System.out.println(2);
        else
        System.out.println(1);
       

        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++) 
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) 
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
    //     for(int i=2; i<=n; i++)
	// {
	// 	if(!prime[i])
	// 		for(int j=2*i; j<=n+1; j+=i)
	// 			prime[j]=true;
	// }
        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                System.out.print(1 + " ");
            else
            System.out.print(2 + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        sieveOfEratosthenes(n+1);
        
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


