import java.util.Scanner;

public class SearchinRotatedSortedArray
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i  =0;i<n;i++)
            a[i]= sc.nextInt();

        int k = sc.nextInt();

//        int pivot = findPivot(a,n);
//        int search1 =-1;
//        if(k>=a[0] && k<=a[pivot-1])
//            search1  = binsearch(a,0,pivot-1,k);
//       else
//           search1 = binsearch(a,pivot,n-1,k);
////       return search1;

        int search1 = binarySearch(a,k);


        System.out.println(search1);




    }
    static int binarySearch(int a[], int k)
    {
        int n = a.length;
        int start = 0, end = n-1;

        int mid = 0;
        while(start<=end)
        {
            mid = (start+end)/2;


            if(a[mid]==k)
                return  mid;
            else if(a[mid]>=a[start])
            {
                if(k<=a[mid] && k>=a[start])
                    end = mid-1;
                else
                    start= mid+1;

            }

            else
                {
                    if(k>=a[mid] && k<=a[end])
                        start = mid+1;
                    else
                        end = mid-1;

                }
        }
        return -1;

    }

















    //this logic is good but giving tle so we will run single binary search looop

    static int binsearch(int a[], int start, int end,int k )
    {

        int mid ;
        while(start <= end)
        {
            mid = (start +end)/2;

            if(a[mid]==k)
                return  mid;
            if(a[mid]<k)
                start= mid+1;
            else
                end = mid -1;
        }
        return  -1;

    }
    static  int findPivot(int a[], int n)
    {
        int pivot = 0;
        int start = 0, end = n-1;
        int prev ,next,mid;

        while(start<end)
        {
            mid = start + (end-start)/2;
            prev = (mid -1 +n)%n;
            next = (mid+1) % n;

            if(a[mid] < a[next] && a[mid] < a[prev])return mid;
            if(a[mid]>=a[start])
                start =mid;
            else
                end  = mid;



        }
        return  0;

    }
}
