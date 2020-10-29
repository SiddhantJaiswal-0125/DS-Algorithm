import java.util.ArrayList;
import java.util.Scanner;

public class checkforTree
{
    static boolean []isVisited;
    static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<>();
        isVisited  = new boolean[noV+1];
        for(int i = 0;i<=noV;i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0; i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        if(noE>noV-1)
        {
            System.out.println("Given Graph is not a tree !");
        }
        else
        {
            int cc_Components=0;
            for(int i = 1;i<=noV;i++)
            {
                if(!isVisited[i])
                {
                    DFS(i);
                    cc_Components++;
                }
            }
            if(cc_Components>1)
                System.out.println("Given Graph is not a tree !");
            else
                System.out.println("Given Graph is a Tree");

        }

    }

    static void DFS(int src)
    {
        if(!isVisited[src])
        {
            isVisited[src] = true;
            ArrayList <Integer> temp = adj.get(src);
            for(int child : temp)
            {
                DFS(child);
            }

        }





    }

}
