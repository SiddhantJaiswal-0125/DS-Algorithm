import java.util.Scanner;

public class mergeSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ar[] = new int[m+n];
        int ar2[] = new int[n];

        for(int i=0;i<m;i++)
            ar[i] = sc.nextInt();
        for(int i  =0;i<n;i++)
            ar2[i] = sc.nextInt();
        merge(ar, m,ar2,n);
        for(int i = 0;i<m+n;i++)
            System.out.print(ar[i]+"\t");
        System.out.println();



    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i =0, j =0;
        int temp[] = new int[m+n];
        int ind = 0;
        while(i<m&&j<n)
        {
            if(nums1[i] < nums2[j])
                temp[ind] = nums1[i++];
            else
                temp[ind] = nums2[j++];

            ind++;
        }

        for(int in = 0;in<m+n;in++)
            System.out.print(temp[in]+"\t");
        System.out.println();
        while(i<m)
        {
//            System.out.println("INSIDE I");
            temp[ind++] = nums1[i++];
        }
        while(j<n)
        {

            temp[ind++] = nums2[j++];
        }
        for(int in=0;in<m+n;in++)
            nums1[in]  = temp[in];
//        nums1 = temp;




    }
}
