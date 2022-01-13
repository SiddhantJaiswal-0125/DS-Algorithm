import java.util.Scanner;

class test1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String res = get(a, b);
        System.out.println(res);

    }
    static String  get(int a , int b)
    {
        if((a>0 && b>0) || (a<0 && b<0))
            return  "*";
        if(a>0 && b<0)
            return  "-";
        if(a<0 && b>0)
            return  "+";


        return  "";

    }
}