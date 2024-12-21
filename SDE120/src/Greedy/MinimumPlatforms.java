package Greedy;

import java.util.*;
public class MinimumPlatforms
{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int start[] = new int[n];
        int end[] = new int [n];
        for(int i =0;i<n;i++)
            start[i] = sc.nextInt();
        for(int i =0;i<n;i++)
            end[i] = sc.nextInt();

        System.out.println(findPlatform(start, end, n));
    }

    static int findPlatform(int start[], int end[], int n)
    {
        ArrayList<Pair> pairs = new ArrayList();
        for(int i=0;i<n;i++)
            pairs.add(new Pair(start[i], end[i]));
        Collections.sort(pairs);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(pairs.get(0).end);
        for(int i= 1;i<n;i++)
        {
            Pair cur = pairs.get(i);
            if(pq.peek()< cur.st)
            {
                pq.poll();

            }
            pq.add(cur.end);

        }
        return pq.size();

    }


    static class Pair implements  Comparable<Pair>
    {
        int st, end;
        Pair(int a, int b)
        {
            st = a;
            end = b;
        }
        public int compareTo(Pair oth)
        {
            return this.st - oth.st;
        }

    }



//    static int findPlatform(int arr[], int dep[], int n)
//    {
//        if(n==0)
//            return 0;
//        PriorityQueue<Integer> platforms = new PriorityQueue<>();
//        pair p[] = new pair[n];
//        for(int i = 0; i<n;i++)
//        {
//            p[i] = new pair();
//            p[i].start = arr[i];
//            p[i].end = dep[i];
//        }
//        Arrays.sort(p);
//        int end = -1;
//        int count = 1;
//        platforms.add(p[0].end);
//        for(int i =1;i<n;i++)
//        {
//            end = platforms.peek();
//            if(p[i].start>end)
//            {
//                platforms.poll();
//                platforms.add(p[i].end);
//            }
//            else
//            {
//                platforms.add(p[i].end);
//                count++;
//            }
//
//
//
//        }
//        return count;
//    }
//    static class pair implements Comparable<pair>
//    {
//        int start , end ;
//        public int compareTo(pair o)
//        {
//            return this.start - o.start;
//        }
//    }
}



//6
//        900
//        940
//        950
//        1100
//        1500
//        1800
//        910
//        1200
//        1120
//        1130
//        1900
//        2000