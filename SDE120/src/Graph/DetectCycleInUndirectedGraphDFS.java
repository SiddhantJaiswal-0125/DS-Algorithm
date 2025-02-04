package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DetectCycleInUndirectedGraphDFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();

        for(int i = 0; i<V; i++)
            adj.add(new ArrayList<>());

        for(int i=0; i<E; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        System.out.println(adj);
        boolean ans = new DetectCycleInUndirectedGraphDFS().isCycle(adj);
        System.out.println(ans
        );
    }  public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();

        boolean vis[] = new boolean[V];
        for(int i = 0; i<V; i++) {


            if (vis[i] == false) {
                System.out.println("DFS FOR "+i);
                if (isCyclic(adj, vis, i, -1))
                    return true;
            }
        }
        return false;


    }

    boolean isCyclic(ArrayList<ArrayList<Integer>> adj, boolean vis[], int node, int parent)
    {

        vis[node] = true;

        for(int i : adj.get(node))
        {

            if(vis[i]==false){
                if(isCyclic(adj, vis, i, node))
                    return true;

            }
            else if (i != parent)
                return true;

        }


        return false;


    }

}
