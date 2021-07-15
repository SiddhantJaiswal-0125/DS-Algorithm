package Hashing;

import java.util.*;

public class Largestsubarraywith0sum
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        System.out.println(new Largestsubarraywith0sum().maxLen(ar,n));

    }
    int maxLen(int arr[], int n)
    {
        // Your code here\
        int size = arr.length;
        int max =  0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cur = 0;
        for(int i =0;i<size;i++)
        {
            if(arr[i]==0 && max == 0 )
                max = 1;

            cur+=arr[i];
            if(cur==0)
                max = i+1;

            if(hmap.containsKey(cur))
            {
//                System.out.println("FOR "+arr[i]);
                int ind = hmap.get(cur);
                if(max< i -ind )
                    max = i - ind;

            }
            else
                hmap.put(cur,i);






        }

//        System.out.println(hmap);
        return  max;

    }
}
