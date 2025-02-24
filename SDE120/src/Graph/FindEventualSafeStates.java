package Graph;

import java.util.*;

class FindEventualSafeStates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g[][] = new int[n][];

        for(int i =0 ; i <n;i++)
        {
            int k = sc.nextInt();
            int temp[] = new int[k];
            for(int j =0 ; j< k;j++)
            {
                temp[j] = sc.nextInt();
            }

            g[i] = temp;
        }

        List<Integer> ans = new FindEventualSafeStates().eventualSafeNodes(g);
        System.out.println("ANS "+ans);
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> ans= new ArrayList<>();
        boolean isSafe[] = new boolean[graph.length];

        traverse(graph, isSafe);

        for(int i=0;i<graph.length; i++)
            if(isSafe[i])
                ans.add(i);

        return ans;

    }

    void traverse(int g[][], boolean isSafe[])
    {
        int n = g.length;

        boolean vis[]  = new boolean[n];
        for(int i=0; i<n; i++)
            if(g[i].length == 0)
            {
                vis[i] = true;
                isSafe[i]= true;
            }


        for(int i =0; i < n; i++)
        {
            if(vis[i] == false)
            {

//                System.out.println("RUNNING FOR INITIAL  "+i);

                boolean val = dfs(i, g, vis, isSafe, n);
//                System.out.println("GETTING RES FOR I "+i+" \t"+val);
                isSafe[i]= val;
            }
        }

    }

    boolean dfs(int src, int g[][], boolean vis[], boolean isSafe[], int n)
    {
        if(isSafe[src])
            return true;
        if(vis[src])
            return false;

        vis[src] =true;

//        System.out.println("COMING FOR src "+src);

        for(int i=0; i<g[src].length; i++)
        {
//            System.out.println("HERE ");
            if(dfs(g[src][i], g, vis, isSafe, n) == false)
            {

//                System.out.println("HERE @ "+i);
                isSafe[g[src][i]] = false;
                return false;
            }
        }


        isSafe[src] = true;
        return true;
    }


}


//7
//        2
//        1
//        2
//        2
//        2
//        3
//        1
//        5
//        1
//        0
//        1
//        5
//        0
//        0