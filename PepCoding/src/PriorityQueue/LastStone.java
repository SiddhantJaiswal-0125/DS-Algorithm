package PriorityQueue;

import java.util.*;

public class LastStone
{
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones)
            pq.add(i);

        if(pq.size()<2)
            return pq.remove();
        int max,min;
        while(pq.size()>1)
        {
            max = pq.remove();
            min = pq.remove();

            int k = max - min;
            if(k>0)
                pq.add(k);



        }
        if(pq.size()>0)
            return pq.remove();
        return 0;



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = new LastStone().lastStoneWeight(ar);
        System.out.println(ans);

    }
}
