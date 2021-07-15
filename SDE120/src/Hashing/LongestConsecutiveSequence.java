package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        System.out.println(new
                LongestConsecutiveSequence().longestConsecutive(ar));

    }
    public int longestConsecutive(int[] nums) {



        HashSet<Integer> hs = new HashSet<>();
        for(int i =0;i<nums.length;i++)
            hs.add(nums[i]);

        int max =0;



        for (int i =0;i<nums.length;i++)
        {
            if(hs.contains(nums[i]-1))
            {
//                System.out.println("FOR "+nums[i]);
                int j = nums[i];
                while(hs.contains(j))
                    j++;

                if(max< j-nums[i]+1)
                    max =  j - nums[i]+1;

//                System.out.println("MAX "+max);
            }

        }
//        if(nums.length>0 && max ==0)
//            max = 1;
        return  max;

    }
}
