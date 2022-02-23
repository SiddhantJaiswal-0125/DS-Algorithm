import java.util.Scanner;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String in = sc.next();
//        int ans = new ExcelSheetColumnNumber().titleToNumber(in);
//        System.out.println(ans);
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(""));
    }
    public int titleToNumber(String columnTitle) {
        int res = 0;

//        int size = columnTitle.length();
//        int pow = 1;
//        for (int i  =0; i<size; i++)
//        {
//            char ch = columnTitle.charAt(size - i-1);
//
//            int charVal = ch - 'A' +1;
//            res = res + (charVal * pow);
//            pow = pow * 26;
//        }
        double fith = 1.00000;

        double r = 2.293232321;
//        r = r * fith;
        r = Math.round(r * fith);
        System.out.println(r);

        return res;




    }

}
