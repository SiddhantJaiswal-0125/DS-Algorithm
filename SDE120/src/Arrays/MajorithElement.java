package Arrays;

import java.util.*;


public class MajorithElement
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ar[] =new int[n];
        for(int i =0;i<n;i++)
            ar[i] =sc.nextInt();

        System.out.println(new MajorithElement().majorityElement(ar));
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1)
            return nums[0];
        int max = 1;
        int cur =1;
        int ind = 0;
        for(int i = 1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
                cur++;
            else
            {
                if(max<cur)
                {
                    max =  cur;
                    ind  =i-1;
                }
                cur = 1;
            }


        }
        if(max<cur)
        {
            max =  cur;
            ind  =nums.length-1;
        }
        return nums[ind];
    }
}
