import  java.util.*;
public class CourseSchedule2
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++)
                mat[i][j] = sc.nextInt();

        }

        int ans[] = new CourseSchedule2().findOrder(n, mat);


        for(int i : ans)
            System.out.print(i+" ");


    }


    public    boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int i =0;i<prerequisites.length;i++)
        {


            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }
        boolean vis[] = new boolean[numCourses+1];

        for(int i =0;i<numCourses;i++)
        {
            if(!vis[i])
            {
                boolean rec[] = new boolean[numCourses+1];
                if(isCyclicUtil(i, vis, rec, adj ))
                    return  true;
            }
        }

        return  false;
    }
    private  static boolean isCyclicUtil(int i, boolean[] visited,
                                         boolean[] recStack, ArrayList<ArrayList<Integer>> adj)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack,adj))
                return true;

        recStack[i] = false;

        return false;
    }

    public  int[] findOrder(int numCourses, int[][] prerequisites)
    {

        if(canFinish(numCourses,prerequisites))
            return new int[0];

        ArrayList <Edge> graph[] = new ArrayList [numCourses];
        buildgraph(numCourses, prerequisites, graph);
        boolean vis[] = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int v =0;v<numCourses;v++)
        {
            if(!vis[v])
                topo(graph, vis, v, st);
        }

        int ans [] = new int[numCourses];
        int i =0;
        while(st.size()>0)
            ans[i++] = st.pop();

        int re[] = new int[numCourses];
        i--;

        for(int j =0;j<numCourses;j++)
        {
            re[j]  = ans[i--];

        }

        return re;


    }

    void topo(ArrayList<Edge> graph[], boolean vis[], int src, Stack<Integer> st)
    {
        vis[src] = true;
        for(Edge e: graph[src])
            if(!vis[e.nbr])
                topo(graph, vis, e.nbr, st);


        st.add(src);
    }
     void buildgraph(int vtces, int [][] pre, ArrayList<Edge> graph[])
    {
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i =0;i<pre.length;i++)
        {
            int v1= pre[i][0];
            int v2 = pre[i][1];
            graph[v1].add(new Edge(v1, v2));


        }
    }

























    static class Edge
    {
        int v, nbr;
        Edge(int v, int nbr)
        {
            this.v= v;
            this.nbr = nbr;

        }
    }

}
