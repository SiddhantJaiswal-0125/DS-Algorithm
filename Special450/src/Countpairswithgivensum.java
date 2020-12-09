import java.util.Hashtable;
import java.util.Scanner;

public class Countpairswithgivensum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a [] = new int[n];
        int _sum = sc.nextInt();
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        int _ans = solve(a,n,_sum);
        System.out.println(_ans);
    }
    static  int solve(int a[],int n ,int sum)
    {
        int _count  = 0;
        Hashtable <Integer,Integer> ht = new Hashtable<>();
        for(int i = 0;i<n;i++)
        {
            if(!ht.containsKey(a[i]))
                ht.put(a[i],0);

            ht.put(a[i],ht.get(a[i])+1);
        }

        for(int i : a)
        {
            if(ht.containsKey(sum-i))
            {
                _count+=ht.get(sum-i);

            }
            if(sum-i==i)
                _count--;
        }
        return _count/2;

    }
}
