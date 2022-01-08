import java.util.HashSet;
import java.util.Scanner;

public class RestoringPermutation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            HashSet <Integer> bag = new HashSet<>();
            boolean consecutive = false;
            for(int i= 0; i<n;i++)
            {
                a[i] =  sc.nextInt();
                bag.add(a[i]);
                if(i>0 && a[i-1]==a[i]-1)
                    consecutive = true;

            }
            if(bag.contains(2*n)||!bag.contains(1)||consecutive)
            {
                System.out.println(-1);
            }
            else
            {
                int res[] = new int[2*n];
                int  j = 0;
                HashSet<Integer> added = new HashSet<>();
                for(int i = 0;i<n && j<2*n-1;i++)
                {
                    res[j++] = a[i];
                    int k = a[i]+1;
                    added.add(a[i]);
                    boolean get = true;
                    while(get&&k<=2*n)
                    {
                        if(!bag.contains(k) && !added.contains(k)) {
                            res[j++] = k;
                            added.add(k);
                        break;
                        }

                        k++;

                    }



                }
                for(int i = 0;i<2*n;i++)
                    System.out.print(res[i]+" ");
                System.out.println();







            }
        }
    }
}
