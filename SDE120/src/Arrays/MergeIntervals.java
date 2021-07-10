package Arrays;

import java.util.*;

public class MergeIntervals
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[][] = new int[n][2];
        for(int i=0;i<n;i++)
        {
            ar[i][0] = sc.nextInt();
            ar[i][1] = sc.nextInt();

        }
        int ans[][] = merge(ar);
        for(int i  =0;i<ans.length;i++)
            System.out.println(ans[i][0]+"\t"+ans[i][1]);



    }
    public  static int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        ArrayList<pair> ar = new ArrayList<>();
        int i =1;
        pair  p = new pair();
        p.x = intervals[0][0];
        int b = intervals[0][1];
        while(i<intervals.length)
        {
            if(intervals[i][0]<=b)
            {
                if(intervals[i][1]>b)
                    b = intervals[i][1];

            }
            else
            {
                p.y = b;
                ar.add(p);
                p = new pair();
                p.x = intervals[i][0];
                b = intervals[i][1];
            }
            i++;

        }


        p.y = b;
        ar.add(p);

        int ans[][] = new int[ar.size()][2];
        i = 0;
        for(pair pi:ar)
        {
            ans[i][0] = pi.x;
            ans[i][1] = pi.y;
            i++;

        }

        return  ans;
    }
    static class pair
    {
        int x , y;


    }}
