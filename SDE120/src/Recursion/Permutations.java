package Recursion;
import  java.util.*;



public class Permutations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0; i<n;i++)
            ar[i] = sc.nextInt();

        System.out.println(new Permutations().permute(ar));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        List<Integer> asf = new ArrayList<>();
        int size = nums.length;
        boolean vis[]=  new boolean[size];
        recur(nums, vis, asf, finalAnswer, 0, size);
        return finalAnswer;
    }

    public void recur(int nums[], boolean vis[], List<Integer> asf, List<List<Integer>>result, int idx, int size)
    {
        if(idx == size)
        {

//            System.out.println("HERE + "+ asf);
            result.add(new ArrayList<>(asf));
            return;
        }

        for(int i =0; i<size; i++)
        {
            if(vis[i] == false)
            {
                vis[i] = true;
                asf.add(nums[i]);
//                System.out.println("Before : IDX :"+idx+" : " +asf);
                recur(nums, vis, asf, result, idx+1, size);

//                System.out.println("After : IDX :"+idx+" : " +asf);
                vis[i] = false;
                asf.remove(asf.size() - 1);
            }
        }


    }

}
