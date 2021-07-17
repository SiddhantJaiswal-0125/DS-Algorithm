package Greedy;

import java.util.*;

public class NMeetingRooms
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
           int start[] = new int[n];
           int end[] = new int[n];
           for(int i =0;i<n;i++)
               start[i] = sc.nextInt();
        for(int i =0;i<n;i++)
            end[i] = sc.nextInt();
        System.out.println(maxMeetings(start, end,n));


    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        pair p[] = new pair[n];
        for( int i=0;i<n;i++)
        {
            p[i] = new pair();
            p[i].start= start[i];
            p[i].end = end[i];

        }


        Arrays.sort(p);


        int count =0;
        int ending =-1;
        for(pair pi:p)
        {
            if(pi.start>ending)
            {
                count++;
                ending = pi.end;
            }
        }




        return count;
    }
    static class pair implements Comparable<pair>
    {
        int start , end ;
        @Override
        public int compareTo(pair o)
        {
            return this.end - o.end;
        }
    }
}
