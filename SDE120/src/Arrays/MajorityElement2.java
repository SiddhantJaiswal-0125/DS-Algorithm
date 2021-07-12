package Arrays;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ar[] =new int[n];
        for(int i =0;i<n;i++)
            ar[i] =sc.nextInt();

        List<Integer> ans = new MajorityElement2().majorityElement(ar);
        System.out.println(ans);
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int first = -1 , second = -1, c1 =0, c2 =0;
        int size = nums.length;
        for(int i =0;i<size;i++)
        {
            if(nums[i] == first)
                c1++;
            else if(nums[i]==second)
                c2++;
            else if(c1==0)
            {
                c1=1;
                first = nums[i];
            }
            else if(c2==0)
            {
                c2=1;
                second = nums[i];
            }
            else
            {
                c1--;
                c2--;
            }



        }

        c1 = 0;
        c2 =0;
        for(int i : nums)
        {
            if(i==first)
                c1++;
            else if(i==second)
                c2++;
        }

        if(c1>size/3)
            ans.add(first);

        if(c2>size/3)
            ans.add(second);

        return  ans;
    }

    }
