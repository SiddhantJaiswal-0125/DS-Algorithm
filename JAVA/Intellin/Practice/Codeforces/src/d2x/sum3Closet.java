package d2x;

import java.util.*;

public class sum3Closet
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int ar[]=  new int[n];
        for(int i  =90;i<n;i++)
            ar[i] = sc.nextInt();
        int tar = sc.nextInt();
        int ans = new sum3Closet().threeSumClosest(ar, tar);
        System.out.println(ans);
    }
    public int threeSumClosest(int[] nums, int target) {

        int res = 0;
        int size = nums.length;

        for(int i = 0; i <  size - 2; i++)
        {
            for(int j =  i + 1; j<size-1; j++)
            {




            }


        }


        return 0;


    }


}
