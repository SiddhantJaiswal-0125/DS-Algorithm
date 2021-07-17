package Arrays;

import java.util.*;

public class ReversePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        System.out.println(new ReversePairs().reversePairs(ar));
    }
    public int reversePairs(int[] nums) {
        return mergeCount(nums,0, nums.length-1);

    }
      int mergeCount(int nums[], int low, int high)
    {
        if(low>=high)
            return 0;
        int mid = (low+high)/2;
        int inversionCount = mergeCount(nums, low, mid);
        inversionCount += mergeCount(nums, mid+1, high);
        inversionCount += merge(nums, low, mid,high);

        return  inversionCount;
    }


    int merge(int nums[], int low, int mid, int high)
    {
        int cnt = 0;
        int j =  mid+1;
        for(int i = low; i<=mid ;i++)
        {
            while(j<=high && nums[i] > (2*(long)nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }


        ArrayList<Integer> ar = new ArrayList<>();
        int left = low, right =  mid+1;
        while(left<=mid && right <=high)
        {
         if(nums[left]<=nums[right])
             ar.add(nums[left++]);
         else
             ar.add(nums[right++]);
        }
        while(left<=mid)
            ar.add(nums[left++]);
        while(right<=high)
            ar.add(nums[right++]);


        for(int  i= low;i<=high;i++)
            nums[i] = ar.get(i-low);


        return cnt;

    }
}
