import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PrintPermutations
{
    static ArrayList<String > ans ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            ans = new ArrayList<>();
        String ques = sc.next();

        print("",ques);
            Collections.sort(ans);
        for(String s : ans)
            System.out.print(s+" ");

            System.out.println();
        }
    }
    static ArrayList<String> print(String asf, String ques)
    {
        if(ques.length()==0)
        {
            ans.add(asf);
            return ans;
        }
        for(int i =0;i<ques.length();i++)
        {
            char ch = ques.charAt(i);
            String qLpart = ques.substring(0,i);
            String qRpart = ques.substring(i+1);
            String roq = qLpart+ qRpart;
            print(asf+ch,roq);
        }
        return  ans;
    }
}
