//SSSP : single source shortest path for directed graph !!

import java.util.ArrayList;
import java.util.Scanner;

public class SSSPusingDFS
{
   static ArrayList<ArrayList<Integer>> adj ;
   static boolean isVisited[];
   static  int dis[];
   public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<ArrayList<Integer>>();
        dis= new int[noV+1];
            isVisited = new boolean[noV+1];
        for(int i = 0; i<=noV;i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
//            adj.get(b).add(a);
        }
        dfs(1,0);
        System.out.println("length of all the nodes form 1 is :");
        for(int  i = 1;i<=noV;i++)
            System.out.println("Distance of Vertex "+i+" is : "+dis[i]  );
    }
    static void dfs(int src,int len)
    {
        if(!isVisited[src])
        {
            isVisited[src] = true;
            dis[src] = len;
            ArrayList <Integer> temp = adj.get(src);
            for(int items : temp)
            {
                if(!isVisited[items])
                {
                    dfs(items,len+1);
                }
            }
        }

    }
}
