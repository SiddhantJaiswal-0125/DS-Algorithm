package PriorityQueue;

import java.util.*;

public class Subsequencek
{
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<pair>  pq = new PriorityQueue <pair>();
        for(int i =0;i<nums.length;i++)
        {
            pq.add(new pair(nums[i], i));
            if(pq.size()>k)
                pq.remove();

        }
        int ans []= new int[k];
        int i =0;
        PriorityQueue <pair2> pq2 = new PriorityQueue<>();

        while(pq.size()>0)
        {
            pair p = pq.remove();
            pq2.add(new pair2(p.val, p.ind));
        }

        while(pq2.size()>0)
            ans[i++] = pq2.remove().val;
        return ans;



    }
    static class pair implements Comparable<pair>{
        int val , ind;
        pair(int a, int b)
        {
            val = a;
            ind =b;
        }
        public int compareTo(pair ob)
        {
            if(this.val < ob.val)
                return -1;
            return 1;

        }
    }
    static class pair2 implements Comparable<pair2>{
        int val , ind;
        pair2(int a, int b)
        {
            val = a;
            ind =b;
        }
        public int compareTo(pair2 ob)
        {
            if(this.ind < ob.ind)
                return -1;

            return 1;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[]= new int[n];
        for(int i = 0;i<n;i++)
            ar[i] = sc.nextInt();
        int  k = sc.nextInt();
        int ans[] = new Subsequencek().maxSubsequence(ar, k);
        for(int i: ans)
            System.out.print(i+"\t");
        System.out.println();
    }
}
