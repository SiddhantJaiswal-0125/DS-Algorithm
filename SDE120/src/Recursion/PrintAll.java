package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrintAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> ans = new PrintAll().find_permutation(s);

        for(String si : ans)
            System.out.println(si);

    }
    public List<String> find_permutation(String S) {
        // Code here
        List<String> res = new ArrayList<>();
        solve(S, "", res, S);
        Collections.sort(res);
        return res;

    }

    void solve( String S, String asf, List<String> res, String temp)
    {
        if(asf.length()==S.length()) {

            res.add(asf);
        return;
        }

        for(int i =0;i<temp.length();i++)
        {

                if (temp.length() == 1) {

                    solve(S, asf + temp.charAt(i), res, "");
                    return;
                } else {
                    String t = new String(temp.substring(0, i)+temp.substring(i + 1, temp.length()));
                    solve(S, asf + "" + temp.charAt(i), res, t);
                }



        }
    }
}
