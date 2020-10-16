//https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

//we have to do this with using constant extra space
//Using Two pointer technique


import java.util.Scanner;

public class MoveAllNegativeAndPositive
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int  i = 0;i < n;i++)
            a[i] = sc.nextInt();
        int left = 0, right = n-1;
        while(left<=right)
        {
            if(a[left] < 0 && a[right] < 0)
                left++;
            else if(a[left] > 0 && a[right] < 0)
            {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
            }
            else if (a[left] > 0 && a[right] > 0)
            {
                right--;
            }
            else
            {
                left++;
                right--;
            }
        }




        for(int i = 0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();





    }
}
