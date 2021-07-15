package Hashing;

import java.util.*;

public class TwoSum
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] =  new int[n];
        for(int i=0 ;i<n;i++)
            ar[i] = sc.nextInt();
        int tar = sc.nextInt();
        int ans[] = new TwoSum().twoSum(ar, tar);
        System.out.println(ans[0]+"\t"+ans[1]);

    }
    public int[] twoSum(int[] nums, int target)
    {

        HashMap <Integer,Integer> hs = new HashMap<>();

        int size = nums.length;
            int ans[] = new int[2];
        for(int i= 0;i<size;i++)
        {
            if(nums[i]>=target)
                continue;

            int k = target - nums[i];
            if(hs.containsKey(k))
            {
                ans[0] = hs.get(k);
                ans[1] = i;

            }
            else
                hs.put(nums[i],i);


        }

        return  ans;


    }
}
