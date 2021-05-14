import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS
{
   static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer>  res = new ArrayList<>();

        boolean visited[] = new boolean[V];


        LinkedList<Integer> queue = new LinkedList<Integer>();


        visited[0]=true;
        queue.add(0);

        while (queue.size() != 0)
        {

            int s = queue.poll();
            res.add(s);

            for(int i : adj.get(s))
            {
                if(!visited[i])
                {
                    visited[i]= true;
                    queue.add(i);

                }

            }


        }
        return  res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NO of Vertex");
        int noV = sc.nextInt();
        System.out.println("Enter No of Edges");
        int noE = sc.nextInt();
        ArrayList <ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<=noV;i++)
            adj.add(new ArrayList<>());
        for(int i =0;i<noE;i++) {
            addEdge(sc.nextInt(), sc.nextInt(),adj);
        }
        ArrayList<Integer>  ans = bfsOfGraph(noV,adj);
        for(int i : ans)
            System.out.print(i+ " ");
        System.out.println();

    }
    static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    static  void printGraph(ArrayList<ArrayList<Integer>> adj)
    {
        for(int i =0 ;i<adj.size();i++)
        {
            System.out.print(i+" : ");
            for(int j =0;j<adj.get(i).size();j++)
                System.out.print(adj.get(i).get(j)+" ");
            System.out.println();

        }
    }
}
