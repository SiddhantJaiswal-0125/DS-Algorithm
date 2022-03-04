import java.util.Scanner;

public class BString {
    public String addBinary(String a, String b) {
        int carry = 0 ;
        int i = a.length() -1;
        int j = b.length() -1;
        String res = "";
        while(i>=0 && j>=0)
        {
            int lastA =(int) a.charAt(i) - '0';
            int lastB =(int) b.charAt(j)-'0';

            if(carry == 1)
                if(lastA ==1 && lastB ==1 )
                    res ="1"+res;
                else if(lastA == 0 && lastB ==0) {
                    res = "1" + res;
                  carry = 0;
                }else
                    res= "0"+res;


            else
                if(lastA ==1 && lastB ==1 )
                {
                    res ="0"+res;
                    carry =1;
                }
                else if(lastA == 0 && lastB ==0)
                    res = "0"+res;
                else
                    res= "1"+res;



            i--;
            j--;
        }


        while(i>=0)
        {

            int lastA =(int) a.charAt(i) - '0';
            if(carry ==1)
            {
                if(lastA == 1)
                {
                    res = "0"+res;
                }
                else
                {
                    res = "1"+res;
                    carry = 0;
                }
            }
            else
            {
                if(lastA == 1)
                    res = "1" + res;
                else
                    res = "0"+res;


            }
            i--;
        }
        while(j>=0)
        {
            int lastA =(int) b.charAt(j)- '0';
            if(carry ==1)
            {
                if(lastA == 1)
                {
                    res = "0"+res;
                }
                else
                {
                    res = "1"+res;
                    carry = 0;
                }
            }
            else
            {
                if(lastA == 1)
                    res = "1" + res;
                else
                    res = "0"+res;


            }




            j--;
        }

        if(carry==1)
            res = "1" +res;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s2 = sc.next();
        String res = new BString().addBinary(s,s2);
        System.out.println(res);
    }

}
