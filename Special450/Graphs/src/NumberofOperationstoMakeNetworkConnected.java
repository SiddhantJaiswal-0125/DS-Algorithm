import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class NumberofOperationstoMakeNetworkConnected
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        System.out.println("Enter Connections :");
        int noOfCon = sc.nextInt();
        int con[][] = new int[noOfCon][2];
        for(int i =0;i<noOfCon;i++)
        {
            for(int j = 0;j<2;j++) {
                con[i][j] = sc.nextInt();
            }
        }
     int ans =    new NumberofOperationstoMakeNetworkConnected().makeConnected(n, con);
        System.out.println(ans);




    }
    public int makeConnected(int n, int[][] con)  {
        int connections = con.length;
        if(connections<n-1)
            return  -1;
        else
        {
            int cc =0;
            ArrayList <ArrayList<Integer> > adj = new ArrayList<>();
            for(int i =0;i<=n;i++)
                adj.add(new ArrayList<>());
            for(int i = 0;i<connections;i++)
            {

                    addEdge(con[i][0], con[i][1],adj);
            }
            boolean isvisited[] = new boolean[n];
            for(int i =0;i<n;i++)
            {

                if(!isvisited[i])
                {
                    cc++;
                    bfsOfGraph(i,adj,isvisited);
                }

            }


            return  cc -1;

        }
    }
    static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    static void bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj ,boolean [] visited)
    {

        LinkedList<Integer> queue = new LinkedList<Integer>();


        visited[0]=true;
        queue.add(0);

        while (queue.size() != 0)
        {

            int s = queue.poll();
//            res.add(s);

            for(int i : adj.get(s))
            {
                if(!visited[i])
                {
                    visited[i]= true;
                    queue.add(i);

                }

            }


        }

    }
}

