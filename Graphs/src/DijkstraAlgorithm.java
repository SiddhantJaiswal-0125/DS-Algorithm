import java.util.*;
public class DijkstraAlgorithm
{
    public static void main(String[] args) {
        ArrayList  <ArrayList<ArrayList<Integer>>> adj;
        boolean  isVisited[];

        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<>();
        isVisited = new boolean[noV+1];

        for(int i = 0;i<noV;i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w =sc.nextInt();
            ArrayList<Integer> t1 = new ArrayList<>();
            ArrayList<Integer> t2 = new ArrayList<>();
            t1.add(a);
            t1.add(w);
            t2.add(b);
            t2.add(w);
            adj.get(a).add(t2);
            adj.get(b).add(t1);
        }

//        System.out.println("ENTER SOURCE");
        int src = sc.nextInt();
//        System.out.println("LIST IS ");
//        System.out.println(adj);
        int ans[] = dijkstra(noV,adj, src);
        for(int i: ans)
            System.out.print(i+" ");
        System.out.println();

//        System.out.println(adj.get(0).get(0));

    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int ans [] = new int[V];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(S, 0));
        boolean vis[] = new boolean[V+1];
        while(!pq.isEmpty())
        {
            pair rem = pq.remove();
            if(vis[rem.v])
            continue;
            vis[rem.v] = true;
            if(ans[rem.v]!=0)
            ans[rem.v] = Math.min(rem.wsf,ans[rem.v ]);
            else
                ans[rem.v] = rem.wsf;
            for(int i =0;i<adj.get(rem.v).size();i++)
            {
                ArrayList<Integer> ed = adj.get(rem.v).get(i);
              if(vis[ed.get(0)]==false)
                {
                  pq.add(new pair(ed.get(0),rem.wsf+ed.get(1)));

                }


            }
        }



        return  ans;
    }

    static class pair implements Comparable<pair>
    {
        int v, wsf;
        pair(int v, int wsf)
        {
            this.v = v;
            this.wsf = wsf;
        }
        public int compareTo(pair o)
        {
            return this.wsf - o.wsf;

        }
    }

}
