import java.util.*;

public class anu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ar[] []=  new int[m][n];
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++)
                ar[i][j] = sc.nextInt();
        List<Integer> ans = new anu1().intersection(ar);
        System.out.println(ans);

    }
    public List<Integer> intersection(int[][] nums) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        if(nums.length == 1)
        {
            List<Integer> ans = new ArrayList<>();
            for(int i : nums[0])
                ans.add(i);
            return ans;
        }
        for(int i : nums[0])
            temp.add(i);
        for(int  i =1;i<nums.length;i++)
        {
            res = new HashSet<>();
            for(int j =0;j<nums[i].length; j++)
            {
                if(temp.contains(nums[i][j]))
                    res.add(nums[i][j]);
            }
            temp = res;
        }

        Iterator<Integer> iterator = temp.iterator();
        List<Integer> ans = new ArrayList<>();

        while(iterator.hasNext())
            ans.add(iterator.next());
        Collections.sort(ans);
        return ans;

    }
}
