//Topological Sorting is only for acyclic Graph


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSorting
{
static  ArrayList <ArrayList<Integer>> adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
         adj = new ArrayList<>();
        for(int i = 0;i<noV+1; i++)
            adj.add(i,new ArrayList<Integer>());
        for(int i =1;i<=noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
        }
        int a[] = countIndegree(noV);
        Queue <Integer> q = new LinkedList<>();
        for(int i = 1;i<=noV;i++)
            if(a[i]==0)
                q.add(i);
        while (!q.isEmpty())
        {
            int u = q.poll();
            System.out.print(u+" ");
            ArrayList<Integer> temp = adj.get(u);
            for(int child : temp)
            {
                a[child]--;
                if(a[child]==0)
                    q.add(child);

            }


        }












    }
    static  int[] countIndegree(int noV)
    {
        int [] count =new int[noV+1];
        for(int i = 1;i<=noV;i++)
        {
            ArrayList <Integer> temp = adj.get(i);
            for( int child:temp)
            {
                count[child]++;
            }
        }
        return count;
    }
}
