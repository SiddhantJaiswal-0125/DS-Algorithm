import java.util.Scanner;

public class BuddyStrings {
    public static boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length())
            return false;

        int count = 0;
        int i1 =-1, i2 =-1;
        for(int i =0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                count++;
                if(count==1)
                    i1 = i;
                else
                    i2 = i;

            }
        }
        if(count==2)
        {

            return (a.charAt(i1)==b.charAt(i2)  && a.charAt(i2)==b.charAt(i1));
        }
        else
        {
            if(count==0)
            {
                boolean con = false;
                for(int i =0;i<a.length();i++)
                {
                    for(int j = i+1;j<a.length();j++)
                        if(a.charAt(i)==a.charAt(j))
                            return true;
                }

                return false;
            }

            else
                return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(buddyStrings(a,b));
    }
}
