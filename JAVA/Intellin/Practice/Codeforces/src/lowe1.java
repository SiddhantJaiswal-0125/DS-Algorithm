import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class lowe1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test  = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int  m = sc.nextInt();
            int wt[] = new int[n];
            System.out.println("ENTER WT");
            for(int i = 0;i<n;i++)
                wt[i] = sc.nextInt();
            System.out.println("ENTER EDGES");
            int gr[][] = new int[m][2];
            for(int i= 0;i<m;i++)
            {
                int u = sc.nextInt();
                int v  = sc.nextInt();
                gr[i][0] = u;
                gr[i][1] = v;
            }
            int ans[] = solve(n,m, wt, gr);


            System.out.println("ANSWERSSS");
            for(int i :ans)
                System.out.println(i);


        }
    }



        static int [] solve(int  n, int m , int wt[], int gr[][])
        {


            int ans[] = new int[2];

            Graph g1 = new Graph(n);
            for(int i =0 ;i<m;i++)
                g1.addEdge(gr[i][0], gr[i][1]);

          ArrayList<Integer> cutVertex =   g1.AP();

          if(cutVertex.size()==0)
          {
              //eleminate the max, vertex

              int max =  0;
              int ver  = 0;
              for(int i = 0;i<n;i++)
              {
                  if(wt[i] > max)
                  {
                      max = wt[i];
                      ver = i+1;
                  }

              }


              boolean visited[] = new boolean[n+1];
              int count  =0;

              int first = 0, second = 0;
              for(int i = 1 ;i<=n;i++)
              {



                  if(visited[i]==false && i !=ver) {
                      int a = g1.BFS(i, ver, visited, wt);
                      count++;

                      if(count%2==0)
                      {
                          first = a;

                      }
                      else
                      {

                          second = a;
                      }




                  }



              }
              if(ans[0] == 0 && ans[1] == 0)
              {
                  ans[0]  = first;
                  ans[1] = second;

              }
              else if(Math.abs(first-second)<Math.abs(ans[0] - ans[1] ))
              {
                  ans[0]  = first;
                  ans[1] = second;

              }



          }
          
          else {


              for (int cu : cutVertex) {
                  boolean visited[] = new boolean[n + 1];
                  int count = 0;

                  int first = 0, second = 0;
                  for (int i = 1; i <= n; i++) {


                      if (visited[i] == false && i != cu) {
                          int a = g1.BFS(i, cu, visited, wt);
                          count++;

                          if (count % 2 == 0) {
                              first = a;

                          } else {

                              second = a;
                          }


                      }


                  }
                  if (ans[0] == 0 && ans[1] == 0) {
                      ans[0] = first;
                      ans[1] = second;

                  } else if (Math.abs(first - second) < Math.abs(ans[0] - ans[1])) {
                      ans[0] = first;
                      ans[1] = second;

                  }

              }
          }

            return  ans ;
        }

    static class Graph
    {
        private int V;
        int BFS(int s, int cut, boolean visited[], int wt[])
        {

            int val = 0;
            if(s==cut)
                return 0 ;


            LinkedList<Integer> queue = new LinkedList<Integer>();


            visited[s]=true;
            queue.add(s);

            boolean b = true;
            while (queue.size() != 0)
            {
                 b= true;

                s = queue.poll();
                if(s==cut) {
                    b = false;
                    continue;
                }

                if(b)
                {

                    val += wt[s-1];
//                    System.out.print(s+" ");

                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext() )
                {
                    int n = i.next();
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
                }
            }
            return  val;
        }


        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;

        Graph(int v)
        {
            V = v+1;
            adj = new LinkedList[v+1];
            for (int i=0; i<=v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }


        void APUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[], boolean ap[])
        {


            int children = 0;
            visited[u] = true;
            disc[u] = low[u] = ++time;


            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext())
            {
                int v = i.next();


                if (!visited[v])
                {
                    children++;
                    parent[v] = u;
                    APUtil(v, visited, disc, low, parent, ap);

                    low[u]  = Math.min(low[u], low[v]);
                    if (parent[u] == NIL && children > 1)
                        ap[u] = true;

                    if (parent[u] != NIL && low[v] >= disc[u])
                        ap[u] = true;
                }

                else if (v != parent[u])
                    low[u]  = Math.min(low[u], disc[v]);
            }
        }
      ArrayList<Integer>  AP()
        {

            ArrayList<Integer> res = new ArrayList<>();
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            boolean ap[] = new boolean[V];

            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
                visited[i] = false;
                ap[i] = false;
            }
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    APUtil(i, visited, disc, low, parent, ap);


            for (int i = 0; i < V; i++)
                if (ap[i] == true)
                {
                    res.add(i);
                }
            return res;
        }
    }




}
