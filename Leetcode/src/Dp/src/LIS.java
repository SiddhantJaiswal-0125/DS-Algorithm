import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = new Solution().lengthOfLIS(ar);
        System.out.println(ans);

    }
    static class  Solution {
        public int lengthOfLIS(int[] nums) {
            int size = nums.length;
            int dp [] = new int[nums.length];
            dp[0] = 1;
            for(int i = 1;i<size;i++)
            {

                for(int j =0;j<i;j++) {

                    if (nums[j] < nums[i]) {

                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }dp[i] = Math.max(dp[i],1);
//                System.out.println("Dp of "+i+"  "+dp[i]);
            }



            int max = -1;
            for(int i : dp)
                max = Math.max(max, i);
            return max;


        }
    }
}
