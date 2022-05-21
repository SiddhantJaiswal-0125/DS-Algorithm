import java.util.Scanner;

class A
{
    String name;

    A(String s)
    {
        name = s;
    }
    void display()
    {
        System.out.println("IN A");
    }

}
class B extends  A{
    String name;
    B(String s)
    {
        super(s);
        name = "RAHUl";
    }
//    void display()
//    {
//        System.out.println("IN B");
//    }

}
public class MinimumSizeSubarraySum
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A ob1 = new B("SIDD");
        System.out.println(ob1.name);
        ob1.display();












//        int n = sc.nextInt();
//        int ar[] = new int[n];
//        for(int i =0;i<n;i++)
//            ar[i] = sc.nextInt();
//        int tar = sc.nextInt();
//        int ans = new Solution().minSubArrayLen(tar, ar);
//        System.out.println(ans);

    }
    static  class Solution {
        public int minSubArrayLen(int s, int[] a) {
            if (a == null || a.length == 0)
                return 0;

            int i = 0, j = 0, sum = 0, min1 = Integer.MAX_VALUE;

            while (j < a.length) {
                sum += a[j++];

                while (sum >= s) {
                    min1 = Math.min(min1, j - i);
                    sum -= a[i++];
                }
            }

            return min1 == Integer.MAX_VALUE ? 0 : min1;
        }
    }

}
