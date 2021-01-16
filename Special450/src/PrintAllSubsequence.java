import java.util.Scanner;

public class PrintAllSubsequence
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        find("",0,n,s);
    }
    static  void find (String temp, int i ,int n ,String s )
    {
        if(i==n)
            System.out.println(temp);
        else
        {
            find(temp,i+1,n,s);

            temp +=s.charAt(i);
            find(temp,i+1,n,s);
        }
    }
}
