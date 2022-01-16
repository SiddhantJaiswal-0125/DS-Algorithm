package PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SuperUglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ni = sc.nextInt();
        int ar[] = new int[ni];
        for(int i =0;i<ni;i++)
            ar[i] = sc.nextInt();
        int n = sc.nextInt();
        int ans =  new SuperUglyNumber().nthSuperUglyNumber(n, ar);
        System.out.println(ans);
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1)
            return  1;
        HashMap<Integer,Integer>  hashMap = new HashMap<>();


        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);

        int cou [] = new int[primes.length];
        for(int i =1;i<n;i++)
        {
            int min = Integer.MAX_VALUE;
            int v = 0, ind =0;
            for(int j =0;j<primes.length;j++)
            {
                min = Math.min(ar.get(cou[j]) * primes[j], min);

            }
            for(int j =0;j<primes.length;j++)
            {
                if(min == ar.get(cou[j])  * primes[j])
                        cou[j]++;
            }


            ar.add(min);

        }

        return  ar.get(n-1);
    }
}
