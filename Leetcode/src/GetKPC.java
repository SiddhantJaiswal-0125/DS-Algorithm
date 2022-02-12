import java.io.*;
import java.util.*;

 class Main4 {

    public static void main(String[] args) throws Exception {
        Scanner sc  = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> res = getKPC(s);
        System.out.println(res.toString());


    }

    public static ArrayList<String> getKPC(String str) {
        ArrayList<String> res = new ArrayList<>();

        int size = str.length();
        if(size==0)
            return res;

        String ar[] = new String[10];
        ar[0] = ".;";
        ar[1] = "abc";
        ar[2] = "def";
        ar[3] = "ghi";
        ar[4] = "jkl";
        ar[5] = "mno";
        ar[6] = "pqrs";
        ar[7] = "tu";
        ar[8] = "vwx";
        ar[9] = "yz";




        solve(str, 0,ar,res,size,"");
        return res;


    }
    static void solve(String s, int i,String ar[], ArrayList<String> res,int size,String t)
    {

        if(i==size)
        {
            res.add(t);
            return;
        }

        else
        {
            String tc = ar[s.charAt(i) - '0'];
            // t = t+""+s.charAt(i);

            for(int j= 0;j<tc.length();j++)
            {
                solve(s, i+1, ar, res, size, t+""+tc.charAt(j));
            }
            return;
        }

    }






}

