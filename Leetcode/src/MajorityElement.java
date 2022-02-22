import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int ar[] = new int[n];
        for(int i  =0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = new Solution().majorityElement(ar);
        System.out.println(ans);
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        for(int i : nums)
        {
            if(i==ele)
                count++;
            else if(count == 0)
            {
                count = 1;
                ele = i;
            }
            else count--;
        }

        return ele;
    }
}