/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
class CandidateCode2
{
   static boolean prime[] = new boolean[1000002];
  static   void sieveOfEratosthenes(int n)
    {



        for (int i = 0; i <= n; i++)
            prime[i] = true;
        for (int p = 2; p * p <= n; p++)
        {
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    public static void main(String args[]) {
        int N = 1000000;
        sieveOfEratosthenes(N);
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();


            int l1 = 0;int r1 = 0;

            for(int i = l;i<=r;i++)
            {
                if(prime[i])
                {
                    l1 = i;
                    break;
                }
            }
            for(int i = r ;i>=l;i--)
            {
                if(prime[i])
                {
                    r1 = i;
                    break;
                }

            }
            if(l1 == 0 && r1 == 0)
                System.out.println(-1);
            else System.out.println(r1 - l1);


        }


    }



}
