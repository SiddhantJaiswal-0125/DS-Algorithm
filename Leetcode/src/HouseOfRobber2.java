import java.util.Scanner;

public class HouseOfRobber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[] = new int[n];
        for(int i =0;i<n;i++)
            mat[i] = sc.nextInt();
        int ans = new Solution().rob(mat);
        System.out.println(ans);

    }
   static class Solution {
        public int rob(int[] nums) {
            if(nums.length==1)
                return nums[0];

            int dp [][] = new int [2][nums.length+1];
            //1st row for including first
            //2nd Row Excluding 1st element
            dp[0][1] = nums[0];
            for(int i = 1;i<nums.length;i++)
            {
                int maxfirst = -1;
                int maxsecond = -1;
                for(int  j = 0; j<i;j++)
                {
                    maxfirst = Math.max(dp[0][j],maxfirst);
                    maxsecond = Math.max(dp[1][j],maxsecond);
                }
                dp[0][i+1] = nums[i] + maxfirst;
                dp[1][i+1] = nums[i] + maxsecond;
            }
            int max =  -1;
            for(int i = 0;i<=nums.length;i++)
            {
                if(i == nums.length)
                {
                    max = Math.max(dp[1][i],max);
                }
                else
                {
                    max = Math.max(dp[0][i],max);
                    max = Math.max(dp[1][i],max);
                }

            }


            return max;
        }
    }
}
