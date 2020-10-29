import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleUsingKahnAlgo
{
   static  ArrayList<ArrayList<Integer> > adj ;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<>();
        for(int i = 0;i<= noV ; i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
        }

        int count[] = countIndegree(noV);
        int c =0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<noV+1;i++)
            if(count[i]==0)
                q.add(i);

        while(!q.isEmpty())
        {
            int p = q.poll();
            c++;
            for(int item : adj.get(p))
            {
                count[item]--;
                if(count[item]==0)
                {
                    q.add(item);

                }

            }
        }
        if(c!=noV)
            System.out.println("YES Cycle exist");
        else
            System.out.println(" NO Cycle");





    }
    static  int [] countIndegree(int noV)
    {
        int indegree[] = new int[noV+1];

        for(int i = 1;i<noV+1;i++)
        {
            ArrayList<Integer> temp = adj.get(i);
            for(int  child: temp)
                indegree[child]++;


        }
        return  indegree;

    }
}
