import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sudoko
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] =new int[n];
        for(int i  =0;i<n;i++)
            ar[i] = sc.nextInt();

        List<List<Integer>> res = new sudoko().permute(ar);
        System.out.println(res);

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ar = new ArrayList<>();
        if(nums.length == 0)
            return ar;

        List<Integer> temp = new ArrayList<>();
        int size = nums.length;

        for(int i = 0 ;i<size; i++)
        {
            temp = new ArrayList<>();
            for(int j  = 0;j<size;j++)
                if(i!=j)
                    temp.add(nums[j]);

            List<Integer> asf =  new ArrayList<>();
            asf.add(nums[i]);
            solve(asf,temp, ar);
        }

        return ar;
    }
    static void solve(List<Integer> asf, List<Integer> rem, List<List<Integer>> res )
    {
        if(rem.size() == 0)
            res.add(new ArrayList<>(asf));

        int size = rem.size();
        for(int i = 0;i<size;i++)
        {
            int ele = rem.get(i);
            asf.add(ele);
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j<size;j++)
                if(i!=j)
                {
                    temp.add(rem.get(j));
                }

            solve(asf,temp, res);
            asf.remove(asf.size()-1);


        }





    }
}
