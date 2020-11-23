/* this program simply stores the in out time of each node in a graph */
/*it can be use in problems like to say whether a node is a part of subtree
 of another node or not */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InOutTime
{
    static ArrayList<ArrayList<Integer>> adj;
    static  boolean  isVisited[];
    static  int intime[];
    static int []outtime;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<>();
        isVisited = new boolean[noV+1];
        intime = new int[noV+1];
        outtime = new int[noV+1];
        for(int i = 0;i<noV+1;i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfs(1);
        System.out.println("enter for checking :");
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        if((outtime[c1]>outtime[c2]) && (intime[c1]<intime[c2]))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    static int timer = 0;
    static void dfs(int src)
    {
        isVisited[src] = true;
        intime[src] = timer++;
        ArrayList<Integer> temp = adj.get(src);
        for(int child : temp)
        {
            if(!isVisited[child])
                dfs(child);
        }
        outtime[src] = timer++;
    }
}
