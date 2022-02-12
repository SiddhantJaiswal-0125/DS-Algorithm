package Recursion;

import java.util.*;

public class CombinationSum2
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i = 0;i < n; i++)
            ar[i] = sc.nextInt();

        int target = sc.nextInt();


        List<List<Integer>> ans = new CombinationSum2().combinationSum2(ar, target);
        System.out.println(ans);



    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        int size = candidates.length;
        Arrays.sort(candidates);
        solve(res, new ArrayList<>(), 0, size, target, candidates);
        return  res;


    }
    void solve(List<List<Integer>> res, List<Integer> temp, int ind, int size, int target, int can[]) {

            if(target==0)
            {    res.add(new ArrayList<>(temp));
             return;
            }
        for(int i = ind;i<size;i++)
        {
            if(i>ind&& can[i]==can[i-1])
                continue;
            if(can[i]>target)
                break;

            temp.add(can[i]);
            solve(res, temp, i+1, size, target-can[i], can);
            temp.remove(temp.size()-1);
        }


    }
}
