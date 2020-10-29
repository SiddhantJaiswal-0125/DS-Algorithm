import java.util.ArrayList;
import java.util.Scanner;

public class noOfConnectedComponents
{
    static boolean vis[] ;
    static ArrayList<ArrayList<Integer>> adj ;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        vis= new boolean[noV+1];
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<=noV;i++)
            adj.add(i,new ArrayList<>());
            for(int i =0;i<noE;i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj.get(a).add(b);
                adj.get(b).add(a);
            }

            int cc_Count = 0;
            for(int i = 1;i<=noV;i++)
            {
                if(!vis[i])
                {
                    dfs(i);
                    cc_Count++;
                }

            }
        System.out.println(cc_Count);
    }
    static  void dfs(int src)
    {
        vis[src] = true;
        ArrayList<Integer> temp = adj.get(src);
        for(int u:temp)
            if(!vis[u])
                dfs(u);
    }
}
