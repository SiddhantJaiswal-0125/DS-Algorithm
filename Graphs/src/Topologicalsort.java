import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Topologicalsort
{

    public static void main(String[] args) {
   ArrayList<ArrayList<Integer>> adj;
        boolean  isVisited[];

        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<>();
        isVisited = new boolean[noV+1];

        for(int i = 0;i<noV+1;i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int ans [] = topoSort(noV,adj);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean vis[] = new boolean[V];
        int ans[] = new int[V];
        Stack<Integer>  st = new Stack<>();

        for(int i =0;i<V;i++)
            if(vis[i]==false)
                topo(vis,adj,st,i);
//                topo(vis, adj, st,i);
/
            return ans;
    }

    static void topo(boolean vis[], ArrayList<ArrayList<Integer>> adj,
                     Stack <Integer> st, int src)
    {
        vis[src] = true;
        ArrayList <Integer> temp = adj.get(src);
        for(int i :temp)
        {
            if(vis[i]==false)
                topo(vis, adj,st,i );




        }
        st.push(src);
    }

}
