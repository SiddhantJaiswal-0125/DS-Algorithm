package Hashing;

import java.util.*;

public class CountSubarraysWithXorAsK
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i  =0;i<n;i++)
            ar[i] = sc.nextInt();
        int k = sc.nextInt();
        int count = solve(ar,k);
        System.out.println(count);
    }
    static int solve(int ar[], int k)
    {

        //TIME COMPLEXITY = O(n^2);
        //SPACE COMPLEXITY = O(1)

        int count = 0;
        int size = ar.length;
        for(int i = 0;i<size;i++)
        {
            int cur = ar[i];
            if(cur==k)
                count++;
            for(int j =i+1;j<size;j++ )
            {
                cur = cur^ar[j];

                if(cur==k)
                    count++;

            }
        }
        return  count;
    }
    static int solve2(int ar[], int k )
    {
        //TIME COMPLEXITY = O(nlogn);
        //SPACE COMPLEXITY = O(n)


        int xor = 0;
        int size = ar.length;
        int total = 0;
        HashMap<Integer, Integer> hmap  = new HashMap<>();
        for(int i =0;i<size;i++)
        {
            xor = xor ^ ar[i];
            if(hmap.get(xor^k)!=null)
                total+=hmap.get(xor^k);
            if(xor==k)
                total++;

            if(hmap.get(xor)!=null)
                hmap.put(xor, hmap.get(xor)+1);
            else
                hmap.put(xor,1);


        }



            return total;


    }
}
