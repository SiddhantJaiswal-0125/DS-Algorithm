import java.util.Arrays;
import java.util.Scanner;

public class MinSwaps
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int count = minSwaps(ar);
        System.out.println(count);

        
    }
    public static int minSwaps(int nums[])
    {
        int size = nums.length;
        int ar[]=   Arrays.copyOf(nums, size);
        Arrays.sort(ar);

        int count  = 0;
        for(int i=0;i<size;i++)
        {
            if(ar[i]!=nums[i])
            {
                //not equal
                int j = i+1;
                for(;j<size;j++)
                {
                    if(nums[j] == ar[i])
                    {
                        //found
                        break;

                    }
                }


                //swap nums[j]  and nums[i]
                int temp  = nums[i];
                nums[i] = nums[j];
                nums[j]  = temp;

                count++;

            }
        }
     return count;


    }
}
