package Hashing;

import java.util.*;


public class Sum4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  nums[] = new int[n];
        for(int i =0 ;i<n;i++)
            nums[i]  = sc.nextInt();
        int tar = sc.nextInt();
        List<List<Integer>> ls = new ArrayList<>();
        ls = new Sum4().fourSum(nums,tar);
        System.out.println(ls.toString());
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {

        return new ArrayList<>();
    }


}
