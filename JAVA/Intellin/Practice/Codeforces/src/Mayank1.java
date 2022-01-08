import java.util.HashSet;
import java.util.Scanner;

public class Mayank1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of 1st Array");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        System.out.println("Enter Elements of 1st Array");
        for(int i =0;i<n;i++)
            arr1[i] = sc.nextInt();

        System.out.println("Enter Size of 2nd Array");
        int m = sc.nextInt();
        int arr2[] = new int[m];
        System.out.println("Enter Elements of 2nd Array");
        for(int i =0;i<m;i++)
            arr2[i] = sc.nextInt();



        int res [] = findMerge(arr1,arr2,n,m);
        long total =0l;
        for(int i : res)
            total+=i;


        System.out.print("Elements are : ");
        for(int i : res)
            System.out.print(i+"\t");
        System.out.println();
        System.out.println("Output : "+total);


    }
    static  int [] findMerge(int arr1[], int arr2[], int n, int m)
    {
        HashSet<Integer> hs = new HashSet<>();
        for(int i :arr1)
         hs.add(i);

        int size =0;
        for(int i:arr2)
            if(hs.contains(i))
                size++;

        int res [] = new int[size];

        int ind = 0;
        for(int i:arr2)
            if(hs.contains(i))
                res[ind++] = i;


            return  res;



    }
}
