/*Diameter is the longest path b/w two nodes , in naive approach : we can run DFS- n times and find
* the longest path, else their is a better approach !! */
import java.util.Scanner;
import java.util.ArrayList;
public class Diameter
{
    static ArrayList <ArrayList<Integer>>adj;
    static boolean isVisited[];
    static int maxD, maxNode;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        isVisited = new boolean[noV+1];
        adj = new ArrayList<>();
        maxNode = -1;
        maxD = Integer.MIN_VALUE;
        for(int i = 0;i<noV+1;i++)
            adj.add(i,new ArrayList<>());

        for(int i = 1;i<noE+1;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfs(1,0);

        //        getting member which can be end node
        maxD = -1;

        isVisited = new boolean[noV+1];

        //        getting final distance between endnode

        dfs(maxNode,0);
        System.out.println(maxD);





    }
    static void dfs(int node, int d)
    {
        if(maxD<= d)
        {
            maxD = d;
            maxNode = node;
        }
        isVisited[node] = true;
        ArrayList<Integer> temp = adj.get(node);
        for(int child : temp)
        {
            if(!isVisited[child])
            {
                dfs(child,d+1);
            }
        }
    }



}
