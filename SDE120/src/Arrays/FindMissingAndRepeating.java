package Arrays;
import  java.util.*;

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        int ans[] = findTwoElement(ar,n);
        System.out.println(ans[0]+"\t"+ans[1]);

    }
  static   int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[] = new int[2];
        //findDuplicate
      int sum  =0;
      for(int i : arr)
          sum+=i;
//      System.out.println("SUM "+sum);
      ans[0] =findDuplicate(arr, n) ;




      int k  = sum - ans[0];
//      System.out.println(k);

      ans[1]  = ((n*(n+1))/2 )- k;

    return ans;

    }
    static  int findDuplicate(int ar[], int n )
    {
        for(int i=0;i<n;i++)
        {
            int k =  ar[Math.abs(ar[i]) -1];
            if(k<0)
                return  i+1;

            ar[Math.abs(ar[i]) -1]  *= -1 ;
        }
        return  -1;

    }
}
