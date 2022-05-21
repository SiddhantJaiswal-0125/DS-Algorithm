
//Link https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

import java.util.Arrays;
import java.util.Scanner;

public class MaximizeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i <n;i++)
            ar[i] = sc.nextInt();
        int k = sc.nextInt();

        int ans = new MaximizeArray().largestSumAfterKNegations(ar, k);

        System.out.println(ans);
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        int  sum = 0;
        int size = nums.length;
        Arrays.sort(nums);
        int in =0;
        while(k>0 && in<size)
        {
            if(nums[in] < 0)
            {
                nums[in] = Math.abs(nums[in]);
                in++;
                k--;
            }
            else
                break;
        }

        sum =0;
        for(int i=0;i<size;i++) {

//            System.out.print(nums[i]+"\t");
            sum += nums[i];
        }
//        System.out.println();

        if(k>0)
        {

            if(k%2==0)
                return sum;

            else
            {

                int min = Integer.MAX_VALUE;
                for(int i =0;i<size;i++)
                    min =Math.min(min, nums[i]);
//                System.out.println("HERE  "+min+"  sum "+sum );
                return (sum - (2*min));

            }
        }
        else
            return sum;







    }
}