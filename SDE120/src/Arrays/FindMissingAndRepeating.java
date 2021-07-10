package Arrays;
import  java.util.*;

public class FindMissingAndRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();


//        Arrays.sort(ar);
//        for(int i : ar)
//            System.out.print(i+"\t");
//        System.out.println();

        int ans[] = findTwoElement(ar,n);
        System.out.println("ANSWERS :");
        System.out.println(ans[0]+"\t"+ans[1]);

    }
  static   int[] findTwoElement(int arr[], int n) {
        // code here
      int ans[] = new int[2];

      for(int i =0;i<n;i++)
      {
          int k = arr[Math.abs(arr[i])-1];
          if(k<0)
              ans[0]  =Math.abs(arr[i]);
          else
              arr[Math.abs(arr[i])-1 ] *= -1;
      }



      for(int i =0;i<n;i++)
          if(arr[i]>0) {
              ans[1] = i + 1;
              break;
          }

    return ans;

    }

}
