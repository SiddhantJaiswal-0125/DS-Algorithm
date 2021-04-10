import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0;i<n;i++)
                a[i] = sc.nextInt();
            ArrayList <Integer> ans = Solve(a,n);
            System.out.println(ans);

        }
    }
    static  ArrayList<Integer> Solve(int a[] ,int n )
    {
        ArrayList <Integer> ans = new ArrayList<>();
        int ind = n-1;
        while(ind>0 && a[ind] < a[ind-1])
        {
            ind--;

        }
        if(ind==0)
        {
            Arrays.sort(a);

            ans = getconverted(a,n);
            return  ans;
        }
        else
        {
            int pivot = a[ind-1];
//            System.out.println("PIVOT "+pivot);
            for(int  i =n-1;i>=ind;i--)
            {
                if(a[i]>pivot)
                {
                    //swap the elements
                    swap(a,i,ind-1);
                    break;
                }
            }
//            System.out.println("GET BEFORE SORTED");
//            for(int i= 0;i<n;i++)
//                System.out.print(a[i]+" ");
//            System.out.println();

            Arrays.sort(a,ind,n);
            ans = getconverted(a,n);

        }






    return ans;
    }
    static  void swap(int a[] ,int i , int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static  ArrayList<Integer> getconverted(int a[] ,int n)
    {
                ArrayList<Integer> ans = new ArrayList<>();
        for(int  i = 0; i<n;i++)
            ans.add(a[i]);

   return ans;
    }
}
