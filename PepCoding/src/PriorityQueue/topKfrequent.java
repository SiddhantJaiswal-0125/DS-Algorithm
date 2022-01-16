package PriorityQueue;

import  java.util.*;
public class topKfrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i : nums)
        {
            int count = hmap.get(i) == null ? 0:hmap.get(i);
            count++;
            hmap.put(i, count);
        }

        Set<Integer> set = hmap.keySet();
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i : set)
        {
            int fr = hmap.get(i);
            pq.add(new pair(i, fr));
            if(pq.size() > k)
                pq.remove();

        }
        int ans[] = new int[k];
        int i =0;
        while(pq.size()>0)
        {
            ans[i++] = pq.remove().item;
        }
        return ans;


    }
    static class pair implements Comparable<pair>
    {
        int item, freq;
        pair(int i, int f)
        {
            item = i;
            freq = f;
        }

        public int compareTo(pair oth)
        {
            if(this.freq<oth.freq)
                return -1;
            return 1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();;
        int k = sc.nextInt();
        int ans []= new topKfrequent().topKFrequent(ar,k);
        for(int i :ans)
            System.out.print(i+"\t");
        System.out.println();
    }
}
