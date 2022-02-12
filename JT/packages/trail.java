import java.util.Scanner;
import General.Employee;

import marketing.sales;

public class trail
{
    public static void main(String[] args) {
        Scanner sc =   new Scanner(System.in);
        System.out.println("Enter name ");
        String name = sc.next();

        System.out.println("Enter Basic Earning");
        int basicAmount = sc.nextInt();

        sales s1 = new sales(name,basicAmount);
        System.out.println("Name is : "+s1.getEmployName());
        System.out.println("ID is : "+s1.getEmployId());
        System.out.println("allowance is : "+s1.tallowance());
        System.out.println("Total Earinngs :"+ s1.totalEarning());
        System.out.println();

        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Enter name ");
        String name1 = sc.next();
//        System.out.println("NAME IS "+name1);

        System.out.println("Enter Basic Earning");
        int basicAmount1 = sc.nextInt();

        sales s2 = new sales(name1,basicAmount1);
        System.out.println("Name is : "+s2.getEmployName());//error
        System.out.println("ID is : "+s2.getEmployId());
        System.out.println("allowance is : "+s2.tallowance());//error
        System.out.println("Total Earinngs :"+ s2.totalEarning());



    }
}
