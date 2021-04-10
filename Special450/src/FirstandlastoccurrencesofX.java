import java.util.Scanner;

public class FirstandlastoccurrencesofX
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            int key = sc.nextInt();

            for(int i =0;i<n;i++)
                a[i] = sc.nextInt();




            int first = firstOccurence(a,n,key);
            int last = lastOccurence(a,n,key);
            if(first==-1 && last==-1)
                System.out.println(-1);
            else
                System.out.println((first)+" "+(last));

        }


    }
    static int  firstOccurence (int a[], int n, int k)
    {
        int res = -1;
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;

        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(a[mid]==k)
            {
                res = mid;
                end = mid-1;

            }
            else if(a[mid]<k)
               start = mid+1;
            else if(a[mid]>k)
              end = mid-1;



        }
        return  res;
    }
    static int  lastOccurence (int a[], int n, int k)
    {
        int res = -1;
        int start = 0;
        int end = n-1;
        int mid = start + (end-start)/2;

        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(a[mid]==k)
            {
                res = mid;
                start = mid+1;

            }
            else if(a[mid]<k)
                start = mid+1;
            else if(a[mid]>k)
                end = mid -1;



        }
        return  res;
    }
}
