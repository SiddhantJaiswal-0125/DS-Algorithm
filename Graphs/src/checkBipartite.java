import java.util.Arrays;
import java.util.Scanner;

import java.util.ArrayList;
//Bipartite or Two Coloring Problem
//Given a Graph check whether it is a Bipartatite or Not!!
public class checkBipartite
{
    static  ArrayList<ArrayList<Integer>> adj;
    static boolean isVisited[];
    static int color[];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        isVisited = new boolean[noV+1];
        color = new int[noV+1];
        adj = new ArrayList<>();
        for(int i = 0;i<noV+1;i++)
            adj.add(i,new ArrayList<>());

        Arrays.fill(color,-1);
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
//        printGraph(noV);
        isVisited[1] = true;
        color[1] = 0;
        if(isbipartite(1))
            System.out.println("Yes the graph is Bipartite !");
        else
            System.out.println("No, the Graph is not Bipartite");




    }


    //it is just dfs method which return Boolean value
    static boolean isbipartite(int src)
    {
        ArrayList <Integer> temp = adj.get(src);
        for(int u : temp)
        {
            if(!isVisited[u])
            {
                isVisited[u] = true ;

                color[u] = color[src]^1;
                if(!isbipartite(u))
                    return false;

            }
            else if(color[u] == color[src])
                return false;
        }
        return true;
    }
    static void printGraph( int V)
    {
        // add your code here
        for(int i=1;i<V+1;i++)
        {
            ArrayList<Integer> temp = adj.get(i);
            System.out.print(i);
            for(int j=0;j<temp.size();j++)
            {
                System.out.print("-> "+temp.get(j));
            }
            System.out.println();
        }


    }
}
