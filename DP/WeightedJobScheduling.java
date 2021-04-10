import java.util.*;

class WeightedJobScheduling
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        task t[] = new task[n];
        for(int i =0;i<n;i++)
        {
            t[i] = new task();
            t[i].start = sc.nextInt();
            t[i].end = sc.nextInt();
            t[i].profit = sc.nextInt();     
        }
        Arrays.sort(t, new Sortbyend());
        int ans = solve(t,n);
        System.out.println(ans);
        sc.close();
    }
static int solve(task t[] , int n)
{
    int ans[] = new int[n];
    for(int i =0;i<n;i++)
    ans[i]  = t[i].profit;

    for(int i =1;i<n;i++)
    {
        for(int j =0;j<i;j++)
        {
            if(t[i].start >= t[j].end)
            {
                ans[i]  = Math.max(ans[i], ans[j]+t[i].profit);
            }
        }
    }

    int res = -1;
    for(int i : ans)
    res = Math.max(i, res);
    
    // System.out.println(res);



    return res;
}

}

class Sortbyend implements Comparator<task> {
    public int compare(task a, task b)
    {
        return a.end - b.end;
    }
}
class task
{
    int start , end, profit;
}