import java.io.*;
import java.util.*;

class Main6 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        ArrayList<String> res = gss(str);
        System.out.println(res.toString());

    }

    public static ArrayList<String> gss(String str) {
        ArrayList<String> res = new ArrayList<String>();
        solve(str, res, 0, str.length(),"");
        return res;
    }
    public static void solve(String s, ArrayList<String> res, int i, int size, String t)
    {
        if(i==size)
        {
            res.add(t);
            return;
        }
        else
        {
            solve(s, res, i+1, size, t);
            solve(s, res, i+1,size, t+""+s.charAt(i));


            return;

        }


    }

}