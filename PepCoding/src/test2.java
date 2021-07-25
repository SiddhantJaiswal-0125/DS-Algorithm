import java.util.Scanner;

public class test2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(new test2().solve(s));
    }
    String solve(String s)
    {
        int ind = 0;
        for(int i =1;i<s.length();i++)
        {
            if(s.charAt(i-1)>s.charAt(i))
            {
                ind = i-1;
                break;

            }

        }

        String res = "";
        for(int i  =0;i<s.length();i++)
        {
            if(i==ind)
                continue;
            else
                res=  res+""+s.charAt(i);
        }

        return  new String(res);
    }
}
