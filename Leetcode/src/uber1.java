
import java.util.*;
public class uber1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int x = sc.nextInt();
//        makeCombi(n, x);
//    }
//
//    static Vector<Vector<Integer>> ans = new Vector<Vector<Integer>>();
//    static Vector<Integer> tmp = new Vector<Integer>();
//
//    static void makeCombiUtil(int n, int left, int k) {
//        if (k == 0) {
//            ans.add(tmp);
//            for (int i = 0; i < tmp.size(); i++)
//                System.out.print(tmp.get(i) + "");
//            System.out.println();
//            return;
//        }
//        for (int i = left; i <= n; ++i) {
//            tmp.add(i);
//            makeCombiUtil(n, i + 1, k - 1);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
//
//
//    static Vector<Vector<Integer>> makeCombi(int n, int k) {
//        makeCombiUtil(n, 1, k);
//        return ans;
//    }
//}



















    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int x = sc.nextInt();
        ArrayList<String>  res = solve(n,x);
        Collections.sort(res);
      for(int  i =0;i<res.size();i++)
            System.out.println(res.get(i));

    }
    static  ArrayList<String>  solve(int n, int x)
    {
        ArrayList<String> res = new ArrayList<>();

        for(int i = 1;i<n;i++)
        {
            find(""+i, 1,n,x,res, i);
        }
        return  res;
    }
    static  void find(String asf, int ind, int n, int x, ArrayList<String> res, int no)
    {
        if(ind == x)
        {
            res.add(new String(asf));
            return;
        }
        for(int i = no+1;i<=n;i++)
            find(asf+""+i, ind+1,n,x,res,i);
        return;
    }
}