import  java.util.*;

public class positiveSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ar[] = s.split(",");
        int ar1[] = new int[ar.length];

        for(int i = 0;i<ar.length;i++)
            ar1[i] = Integer.parseInt(ar[i]);
        int ans =new positiveSubarray().getMaxLen(ar1);
        System.out.println(ans);





//        70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86
    }

//1,2,3,5,-6,4,0,10
    static  int mod = Integer.MAX_VALUE;
    int mul(long a, int b)
    {
        return (int)(a%mod * b%mod)%mod;
    }
    public   int getMaxLen(int[] nums) {


        int maxLen = 0;
        long pro = 1l;
        int size = nums.length;
        int k =0;
        for(int i = 0;i<size; i++)
        {
            if(pro>0)
                pro = 1;
            else if(pro<0)
                pro = -1;
//            else   if(pro == 0)
            else
            {
                pro = nums[i];
                k=0;

            }
//            else
//            pro = mul(pro, nums[i]);
            pro = pro * nums[i];

            k++;
            if(pro>0)
                maxLen = Math.max(k, maxLen);

        }
        pro = 1;
        k =0;
        for(int i = size-1 ;i>=0;i--)
        {
//
//            if(pro == 0)
//            {
//                pro = nums[i];
//                k=0;
//            }
//            else
//                pro = mul(pro, nums[i]);

            if(pro>0)
                pro = 1;
            else if(pro<0)
                pro = -1;
//            else   if(pro == 0)
            else
            {
                pro = 1;
                k=0;

            }
//            else
//            pro = mul(pro, nums[i]);
            pro = pro * nums[i];
            k++;


            if(pro>0)
                maxLen = Math.max(k, maxLen);
        }
        return  maxLen;

    }





    static  int solve(int nums[])
    {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;


            int index1 = -1;
            int index2 = -1;
            int negCount = 0;
            int j;

            for (j = i; j < nums.length; j++) {

                if (nums[j] == 0) break;

                if (nums[j] < 0) {
                    if (index1 == -1)
                        index1 = j;
                    index2 = j;
                    negCount++;
                }
            }
            int start = i;
            int end = j-1;

            if (negCount % 2 == 0) {
                max = Math.max(max, end - start + 1);
            } else {
                int minDist = end - index2 + 1;
                minDist = Math.min(minDist, index1 - start + 1);
                max = Math.max(max, end - start - minDist + 1);
            }
            i = end;
        }

        return max;
    }


}

