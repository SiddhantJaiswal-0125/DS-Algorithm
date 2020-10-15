import java.util.Scanner;

public class test
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int min = findmin(a,b,c);
        int max = findmax(a,b,c);
        if(a!=max&&a!=min)
            System.out.println(a);
        else if (b!=max && b!=min)
            System.out.println(b);
        else
            System.out.println(c);

    }
    static int findmin(int a,int b,int c)
    {
        if(a<b&&a<c)
            return a;
        else if(b < c)
            return  b;
        else
            return  c;



    }
    static int findmax(int a,int b,int c)
    {
        if(a>b&&a>c)
            return a;
        else if(b > c)
            return  b;
        else
            return  c;



    }
}
