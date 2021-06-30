import java.util.*;

public class ContainerWithMostWater
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        System.out.println(maxArea(ar));

    }
    public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        List<List<Integer>> ans =  new ArrayList<>();
        for(int i =0;i<size-2;i++)
        {
            for(int  j  = i+1;j<size-1;j++)
            {
                for(int k = j+1;k<size;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ans.add(temp);


                    }
                }
            }
        }
        return ans;


    }
    public static int maxArea(int[] h) {
        int size = h.length;
        int fgl[] = new int[size];
        int fgr[] = new int[size];
        ArrayList<Integer> ar = new ArrayList<>();

        //for left
        for(int i =size-1;i>=0;i--)
        {
            fgl[i] = i;
            for(int j =i-1;j>=0;j--)
            {
                if(h[j]>=h[i])
                    fgl[i] = j;

            }


        }
        //for right

        for(int i =0;i<size;i++)
        {
            fgr[i] = i;
            for(int j =i+1;j<size;j++)
                if(h[j]>=h[i])
                    fgr[i] = j;



        }
        int wt[] = new int[size];
        for(int i =0;i<size;i++)
            wt[i] =  (fgr[i] - fgl[i]) * h[i];


        int max = 0;
        for(int i : wt)
            max = Math.max(max, i);


            return max;

    }
}
