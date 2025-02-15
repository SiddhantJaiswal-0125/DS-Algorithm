package Top150Leetcode;

import java.util.Scanner;

public class SlidingWindowMinimumSizeSubarraySum {

        public int minSubArrayLen(int target, int[] nums) {
            int  i = 0, j = 0, size = nums.length;
            int ans = size+1, total = 0;
            while(j < size)
            {
                total+=nums[j];
                while(total>=target)
                {
                    int temp = j - i + 1;
                    ans = Math.min(temp, ans);

                    total -= nums[i];
                   i++;
                }
                j++;
            }




            return ans == size+1 ? 0:ans;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];

        for(int i =0; i < n; i++)
            ar[i] = sc.nextInt();

        int tar  = sc.nextInt();
        int ans = new SlidingWindowMinimumSizeSubarraySum().minSubArrayLen(tar, ar);

        System.out.println(ans);
    }
}


//6
//        2
//        3
//        1
//        2
//        4
//        3
//        7