import java.util.*;

public class TopKFrequentElements
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n;i++)
            a[i] = sc.nextInt();
      new TopKFrequentElements().solve(a,n,k);

    }
    void solve(int a[],int n ,int k)
    {
        Hashtable <Integer, Integer> table = new Hashtable<>();
        for(int i = 0;i<n;i++)
        {
            if(!table.containsKey(a[i]))
            {
                table.put(a[i],0);
            }
            table.put(a[i],table.get(a[i])+1);
        }
        int p = n/k;

        Set<Integer> keys = table.keySet();
        int str;
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            str = it.next();


            if(table.get(str)>=k)
                System.out.print(str+" ");

        }
        System.out.println();
    }
}
