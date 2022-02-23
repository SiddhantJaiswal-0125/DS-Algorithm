import java.util.*;

public class ContainsDuplicate2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int k = sc.nextInt();
        boolean ans = new ContainsDuplicate2().containsNearbyDuplicate(ar, k);
        System.out.println(ans);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
