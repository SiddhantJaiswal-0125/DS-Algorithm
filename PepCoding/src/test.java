import java.io.*;
import java.util.*;

 public class test {


    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public ArrayList<Connection> minimumCostConnection(int num,ArrayList<Connection> connection)
    {

        int vtces = num;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
            ArrayList<Edge> iu= new ArrayList<>();
            graph.add(iu) ;
        }
        int ind = 0;
        Hashtable<String , Integer>  hmap = new Hashtable<>();
        Hashtable<Integer , String>  hmap2 = new Hashtable<>();
        ArrayList<Connection> res = new ArrayList<>();
        for (Connection c : connection)
        {
            if(hmap.containsKey(c.firstTown) == false)
            {
                hmap.put(c.firstTown, ind);
                hmap2.put(ind, c.firstTown);
                ind++;
            }
            if(hmap.containsKey(c.secondTown) == false)
            {
                hmap.put(c.secondTown, ind);
                hmap2.put(ind, c.secondTown);
                ind++;
            }
        }

        int edges = connection.size();
        for (int i = 0; i < edges; i++) {

            int v1 = hmap.get(connection.get(i).firstTown);
            int v2 =hmap.get(connection.get(i).secondTown);
            int wt = connection.get(i).cost;
            graph.get(v1).add(new Edge(v1, v2, wt));
            graph.get(v2).add(new Edge(v2, v1, wt));
        }
        int src = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, -1, 0));
        Integer[] visited = new Integer[vtces];
        while(queue.size() > 0){
            Pair rem = queue.remove();
            if(visited[rem.v] != null){
                continue;
            }
            visited[rem.v] = rem.p;
            if(rem.p != -1){
                Connection ci = new Connection(hmap2.get(rem.p),hmap2.get(rem.v), rem.wt);
                res.add(ci);
            }

            for (Edge e : graph.get(rem.v)) {
                if (visited[e.nbr] == null) {
                    queue.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
        return  res;
    }

    static class Pair implements Comparable<Pair> {
        Integer v;
        Integer p;
        int wt;

        Pair(Integer v, Integer p, int wt){
            this.v = v;
            this.p = p;
            this.wt = wt;
        }

        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }





}




class Connection
{
    public String firstTown;
    public String secondTown;
    public int cost;
    Connection(String t1, String t2, int c)
    {
        firstTown = t1;
        secondTown = t2;
        cost = c;
    }
}



