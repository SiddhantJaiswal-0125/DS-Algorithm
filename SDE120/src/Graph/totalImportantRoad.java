package Graph;

import  java.util.*;

public class totalImportantRoad {

    public int edgeScore(int[] edges) {
        int n = edges.length;
        int val[] = new int[n];

        for(int i =0;i<n;i++)
        {
            val[edges[i]] +=i;
        }
        int max = -1, idx = -1;

        for(int i=0; i <  n; i++)
        {
            if(val[i] > max)
            {
                max = val[i];
                idx= i;
            }
        }
        return idx;
    }
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];

        for (int[] edge : roads) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // Arrays.sort(degree);

        // long value = 1;
        // long totalImportance = 0;
        // for (long d : degree) {
        //     totalImportance += (value * d);
        //     value++;
        // }

        int val[]  = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0 ;i<n;i++)
            pq.add(new Pair(i, degree[i]));


        int cnt = n;


        int idx = n-1;
        while(idx >= 0) {
            val[pq.poll().v] = n--;
        idx--;
        }
        long totalImportance = 0;


        for(int i[]:roads)
        {
            totalImportance+=val[i[0]];
            totalImportance+=val[i[1]];
        }






        return totalImportance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int ed[][] = new int[v][2];

        for(int i =0; i<v; i++)
        {
            ed[i][0] = sc.nextInt();
            ed[i][1] = sc.nextInt();
        }

        long ans = new totalImportantRoad().maximumImportance(n, ed);
        System.out.println("ANS "+ans);
    }
    class Pair implements Comparable<Pair>
    {
        int deg, v;
        Pair(int v, int deg)
        {
            this.v = v;
            this.deg = deg;
        }

        public int compareTo(Pair oth)
        {
            return oth.deg - this.deg;
        }
    }
}


//5
//        6
//        0
//        1
//        1
//        2
//        2
//        3
//        0
//        2
//        1
//        3
//        2
//        4