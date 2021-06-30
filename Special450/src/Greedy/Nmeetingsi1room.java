package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//86 32 31 98 37 65 98 71 99 58 59 32 52 69 15 75 4 86 57 36 83 18 58 50 43 29 98 53 80 5 89 73 8 97 17 100 9 21 55 55 32 74 60 32 87 72 54

//126 112 134 138 89 118 107 124 126 83 133 64 124 109 108 132 111 95 82 106 86 118 82 78 92 55 128 121 118 95 94 110 111 146 124 148 95 146 109 61 93 126 74 76 110 78 91
public class Nmeetingsi1room
{
    static  class pair
    {
        int st,end;
        pair(int start, int end )
        {
            st = start;
            this.end = end;
        }



    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int  n= sc.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            System.out.println("ENTER START");
            for(int i= 0;i<n;i++)
                start[i] =sc.nextInt();
            System.out.println("ENTER END");
            for(int i =0;i<n;i++)
                end[i] = sc.nextInt();

            int ans = maxMeetings(start, end,n);
            System.out.println("Maximum Meetings  : "+ans);

        }
        public static int maxMeetings(int start[], int end[], int n)
        {
            // add your code here
            pair [] p = new pair[n];
            for(int i=0;i<n;i++)
            {
                p[i]  = new pair(start[i],end[i]);
            }

            //sorted as per ending time
            Arrays.sort(p, new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    return  o1.end - o2.end;
                }

            });

            int count = 1;
            int lasttime =  p[0].end;
            for(int i =1;i<n;i++)
            {
                if(p[i].st>= lasttime)
                {
                    count++;
                    lasttime = p[i].end;

                }
            }

            System.out.println("PRINTING AFTER SORTED");
            for(pair i: p)
                System.out.println(i.st +"\t"+i.end);
            return  count;
        }



}

