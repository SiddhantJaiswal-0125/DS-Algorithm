package Arrays;

import java.util.*;
public class NextPermutation
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  size = sc.nextInt();
        int ar[] = new int[size];
        for(int i =0;i<size;i++)
            ar[i] = sc.nextInt();
        new NextPermutation().nextPermutation(ar);
        for(int i:ar)
            System.out.print(i+"\t");
        System.out.println();


    }

    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if(size<=1)
            return;
        int i =  size-2;
        while(i>=0)
        {
            if(nums[i]<nums[i+1])
                break;
            i--;


        }
        if(i<0)
        {
            Arrays.sort(nums);
            return;
        }
        else
        {
            int pivot = i;
            i = size-1;
            while(i>=0 )
            {
                if(nums[i]>nums[pivot])
                    break;
                i--;

            }

            if(i>0)
            {
                //swap ar[i] && ar[pivot]
                int temp = nums[i];
                nums[i]  = nums[pivot];
                nums[pivot]  = temp;
                pivot++;

                i= size-1;

                //sort
                while(i > pivot)
                {
                    temp = nums[i];
                    nums[i]  = nums[pivot];
                    nums[pivot]  = temp;
                    pivot++;
                    i--;


                }

            }


        }





    }
}
