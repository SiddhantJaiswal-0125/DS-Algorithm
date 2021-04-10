import java.util.Scanner;

public class CountSquares
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        long n = sc.nextLong();
        n--;

        int a =(int) Math.sqrt(n);
        System.out.println(a);

    }
}
