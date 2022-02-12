import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class TwoSum
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++)
            a[i] = sc.nextInt();

      int ans [] =   twoSum(a,9);

      dis(ans);



    }
    public static int[] twoSum(int[] a, int k)
    {

        Hashtable <Integer, Integer > ht = new Hashtable<>();
        int n = a.length;
        int p[] = new int[2];
        for(int i = 0;i<n;i++)
        {
            int q = k - a[i] ;

            if(ht.containsKey(q))
            {
                p[0] = ht.get(q);
                p[1] = i;

            }
            else {
                ht.put(a[i], i);

                }
        }
        Arrays.sort(p);
        return  p;
    }
    static  void dis(int a[])
    {
        for(int  i : a)
            System.out.print(i+" ");
        System.out.println();

    }
    public  int[] twoSumwithoutHashSet(int[] a, int k)
    {
        int p[]  = new int [2];
        boolean b = true;
        int n = a.length;
        for(int i = 0;i<n && b;i++)
        {
            for(int j = i+1;j<n;j++)
            {
                if(a[i] + a[j] == k)
                {
                    p[0] = i;
                    p[1] = j;
                    b = false;
                    break;
                }
            }

        }
        return p;

    }
}
