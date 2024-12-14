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
        System.out.println(new NMeetingRooms().maxMeetings(start, end));


    }
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        ArrayList<Pair> list = new ArrayList<>();
        int size = start.length;
        if(size==0)
            return 0;
        for(int i =0 ;i<size; i++)
            list.add(
                    new Pair(start[i], end[i])
            );

        Collections.sort(list);

        int cnt = 1;
        int endtime = list.get(0).end;
        int currEnd, currStart;
        for(int i =1; i<size;i++)
        {
            currStart = list.get(i).st;
            currEnd = list.get(i).end;
            if(currStart > endtime)
            {
                cnt++;
                endtime = currEnd;
            }

        }


//        for(Pair p : list)
//        System.out.println(p.toString());


        return cnt;

    }
    class Pair implements Comparable<Pair>
    {
        int st, end;

        Pair(int a, int b)
        {
            st = a;
            end = b;
        }


        @Override
        public String toString() {
            return this.st +"\t" +this.end;
        }

        public int compareTo(Pair oth)
        {
            return this.end - oth.end;
        }
    }
}
