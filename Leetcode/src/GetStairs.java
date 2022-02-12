import java.io.*;
import java.util.*;

 class Mai {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> res = getStairPaths(n);
        System.out.println(res.toString());


    }

    public static ArrayList<String> getStairPaths(int n) {
        ArrayList<String> res = new ArrayList<>();
        if(n==0)
            return res;
        else
        {
            solve(0,n,"",res);
            return res;
        }
    }
    static void solve(int i, int n, String temp, ArrayList<String> res)
    {
        if(i==n)
        {
            res.add(temp);
        }
        else if(i>n)
            return;

        solve(i+1, n, temp+"1", res);
        solve(i+2, n, temp+"2", res);
        solve(i+3,n,temp+"3",res);
        return;

    }

}