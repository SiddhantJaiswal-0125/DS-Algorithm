package Arrays;

import java.util.Scanner;

// Sort an array of 0’s 1’s 2’s without using extra space or sorting algo
public class SortColors
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i]  = sc.nextInt();
        sortcolors(ar);
        for(int  i : ar)
            System.out.print(i+"\t");
        System.out.println();


    }
    public static  void sortColors(int[] nums) {
        int one = 0, two = 0, zero = 0;
        for(int i:nums)
        if(i==1)
            one++;
        else if(i==2)
            two++;
        else if(i==0)
            zero++;


//        System.out.println(zero+"\t"+one+"\t"+two);
        for(int i = 0;i<nums.length; i++)
        {
            if(zero>0)
            {
                zero--;
                nums[i] = 0;
            }
            else if(one>0)
            {
                one--;
                nums[i] = 1;


            }
            else if(two>0)
            {
                two--;
                nums[i] = 2;
            }

        }




    }
    public static void sortcolors(int nums[])
    {
        int low = 0, mid = 0, high = nums.length -1;
        while(mid<high)
        {
            if(nums[mid] ==2)
            {
                //swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;


            }

            else if(nums[mid] == 1)
            {
                mid++;

            }
            else if(nums[mid]== 0)
            {
                //swap low and mid
                int temp = nums[mid];
                nums[mid]  = nums[low];
                nums[low] = temp;

                low++;
                mid++;
            }
        }
    }
}
