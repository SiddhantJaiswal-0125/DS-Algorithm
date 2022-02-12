import java.util.*;

class company
{
    static  int max = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <ArrayList<Integer>> adj = new ArrayList<>();
        int noV = sc.nextInt();
        int edge = sc.nextInt();
        for(int i = 0;i<noV; i++)
            adj.add(i,new ArrayList<Integer>());

        String inp = sc.next();

        for(int i = 1; i<= edge;i++)
        {
            int u = sc.nextInt();
            int v =sc.nextInt();
            adj.get(u-1).add(v-1);
        }
        int degree[] = new int[noV];


        for(int i =0;i<noV;i++)
        {
            for(int it:adj.get(i))
                degree[it]++;
        }


        if(topologicalSort(noV, adj))
            System.out.println(-1);
        else{

        boolean vis[];
        String psf="";
        for(int i = 0;i<noV;i++)
        {
            if(degree[i]==0)
            {
                vis = new boolean[noV];
                bfs(vis, adj, noV, edge, i,psf+""+inp.charAt(i),inp);
            }
        }
        System.out.println(max);
        }
    }

    static void bfs(boolean vis[], ArrayList<ArrayList<Integer>> adj , int v,
                    int e, int src, String psf,String inp)
    {
        vis[src] = true;
        if(adj.get(src).size()==0)
        {
            int ar[] = new int[27];
            for(int i=0;i<psf.length();i++)
                ar[psf.charAt(i) - 'a']++;
            
            for(int i =0;i<27;i++)
                max = Math.max(max, ar[i]);

            vis[src] = false;
            return;


        }
        for(int i : adj.get(src))
        {
            if(vis[i]==false)
              bfs(vis,adj,v,e,i,psf+""+inp.charAt(i),inp);

        }
        vis[src] = false;

    }
    public static boolean topologicalSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int indegree[] = new int[V];

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp
                    = adj.get(i);
            for (int node : temp) {
                indegree[node]++;
            }
        }

        Queue<Integer> q
                = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }


        int cnt = 0;

        Vector<Integer> topOrder = new Vector<Integer>();
        while (!q.isEmpty()) {


            int u = q.poll();
            topOrder.add(u);
            for (int node : adj.get(u)) {
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        if (cnt != V)
            return true;



        return  false;
    }
}


