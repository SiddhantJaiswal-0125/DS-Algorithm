package Graph;


import java.util.*;


class NetworkDelayTime {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int e = sc.nextInt();
         int[][] times = new int[e][3];
         int k = sc.nextInt();

         for(int i =0;i<e;i++)
         {
             times[i][0] = sc.nextInt();
             times[i][1] = sc.nextInt();
             times[i][2] = sc.nextInt();
         }

         int ans = new NetworkDelayTime().networkDelayTime(times, n, k);
        System.out.println("ANS "+ans);
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i<=n ; i++)
            adj.add(new ArrayList<>());

        for(int i =0; i<times.length; i++)
        {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Pair(v, w));
        }

        int dis[] = new int[n+1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Pair>  pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));
        dis[k] = 0;
        HashSet<Integer> set = new HashSet<>();

        while(set.size() != n)
        {

            System.out.println("PQ SIZE "+pq.size());
            if(pq.size() == 0)
                break;


            int nd = pq.remove().node;

            if(set.contains(nd))
                continue;

            System.out.println("HERE ");

            set.add(nd);

            int eDis = -1, nDis = -1;

            for(Pair i : adj.get(nd))
            {
                if(set.contains(i.node))
                    continue;

                nDis = i.wt + dis[nd];

                if(nDis < dis[i.node])
                {
                    dis[i.node] =  nDis;
                    pq.add(new Pair(i.node, nDis));
                }
            }



        }

        int min = -1;

        for(int i= 1;i<=n ;i++) {
            System.out.println("IND "+i+"  val  "+dis[i]);
            min = Math.max(dis[i], min);
        }
        return min == Integer.MAX_VALUE ? -1: min;

    }

    class Pair implements Comparable<Pair>
    {
        int node, wt;
        Pair(int n, int w)
        {
            this.node = n;
            this.wt = w;
        }

        public int compareTo(Pair oth)
        {
            return this.wt - oth.wt;
        }
    }
}


//4
//        3
//        2
//        2
//        1
//        1
//        2
//        3
//        1
//        3
//        4
//        1