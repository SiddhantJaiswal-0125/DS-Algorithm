import java.util.Scanner;

public class SearchInsertPosition
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] =  new int[n];
        for(int i =0 ;i<n;i++)
            a[i] = sc.nextInt();

        int tar = sc.nextInt();

        int ans = solve(a, tar);

        System.out.println(ans);
    }
    static int solve(int a[], int t)
    {
        System.out.println("INSIDE THIS" + t);
        int n = a.length;
        int start = 0;
        int end = n -1;

        int mid = start + (end - start)/2;
        while(start <= end)
        {
            mid = start + (end - start)/2;
            if(a[mid]  == t)
                return mid;

            if(a[mid]<t )
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
      return start;

    }
}
