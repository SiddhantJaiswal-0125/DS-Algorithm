import java.util.Scanner;

/*A Program to check if strings are rotations of each other or not*/
public class areRotations
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String  s2 = sc.next();
        if(check(s1,s2))
            System.out.println("Yes , Both Strings are rotation of each other");
        else
            System.out.println("No , Both are Not rotation of each other");
    }
    static  boolean check (String s1,String s2)
    {
        String temp = s1+s1;
        return  (s1.length()==s2.length() && temp.indexOf(s2)!=-1);
    }
}
