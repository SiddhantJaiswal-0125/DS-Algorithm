import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CycleInDirectedGraph
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        ArrayList <ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<=noV;i++)
            adj.add(new ArrayList<>());

        for(int i =0;i<noE;i++) {
            addEdge(sc.nextInt(), sc.nextInt(),adj);
        }
        System.out.println(new CycleInDirectedGraph().isCyclic(noV, adj));

    }
    static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(a).add(b);
//        adj.get(b).add(a);
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        boolean recSt[] = new boolean[V];
        for(int  i =0;i<V;i++)
            if(DFSrec(i, adj, vis, recSt))
                return true;

            return  false;
    }
    static  boolean DFSrec(int src, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean recSt[])
    {
        vis[src] = true;
        recSt[src] = true;

        for(int u : adj.get(src))
        {
            if(!vis[u])
            {
                if(DFSrec(u,adj,vis,recSt))
                    return  true;

            }
            else if(recSt[u])
                return  true;

        }



        recSt [src] = false;
    return  false;
    }

}
