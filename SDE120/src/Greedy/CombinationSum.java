package Greedy;

import java.util.*;

public class CombinationSum
{
    static  List<List<Integer>> ans ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i = 0;i<n;i++)
            ar[i] = sc.nextInt();
        int tar = sc.nextInt();
        List<List<Integer>> res = new CombinationSum().combinationSum2(ar, tar);

        System.out.println(ans);

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        int size  = candidates.length;
        if(size==0)
            return ans;


        ArrayList<Integer> re = new ArrayList<>();
        solve(candidates, 0, re, target, size,0);
        return  ans;


    }

    static  void solve(int [] can, int index, ArrayList<Integer> tillNow, int target, int size,int sumTillNow)
    {




        if(sumTillNow==target)
        {

            ans.add(tillNow);
            return;

        }
        if(index==size)
            return;

        if(can[index]<=target)
        {

//            System.out.println("HERE"+can[index]);
            solve(can, index+1, tillNow, target, size, sumTillNow);

            tillNow.add(can[index]);

            solve(can, index+1, tillNow, target, size, sumTillNow-can[index]);

            int n = tillNow.size();
            tillNow.remove(n-1);
        }

        else
        {
            //bigger hai mt lo
            solve(can, index+1, tillNow, target, size, sumTillNow);
        }


    }


}
