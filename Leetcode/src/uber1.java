import java.util.Scanner;

public class uber1 {
    static boolean isRotation(String str1, String str2)
    {
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a =  sc.next();
        String b = sc.next();
        System.out.println(isRotation(a,b)?"YES":"NO");
    }
}
