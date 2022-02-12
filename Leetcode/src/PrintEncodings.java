import java.io.*;
import java.util.*;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {
        char ar[] = new char[27];
        for(int i= 1;i<=26;i++)
            ar[i] = (char)('a'+(i-1));
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        printEncodings(s,"");

    }

    public static void printEncodings(String str, String asf) {

        if(str.length()==0)

        {
            System.out.println(asf);
            return;
        }
        int ind =(int)(str.charAt(0)-'0');
        char c =(char)( 'a'+(ind-1));
//        if(str.length()==1)
//        {
//
//            System.out.println(asf+ ""+c);
//            return;
//        }

        String temp1 = str.substring(1);
        printEncodings(temp1, asf+""+c);
        if(ind==1)
        {

            int ind2 =(int)(str.charAt(1)-'0');
            char c2 = (char)( 'a'+(10+ind2-1));

            temp1 =  str.substring(2);

            printEncodings(temp1, asf+""+c2);
        }
        else if(ind==2 )
        {
            int ind2 =(int)(str.charAt(1)-'0');
            if(ind2<=6)
            {
                char c2 = (char)( 'a'+(10+ind2-1));

                temp1 = str.substring(2);

                printEncodings(temp1, asf+""+c2);

            }

        }

    }


}