import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

class test
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int in = sc.nextInt();

        String ans = new test().toggleTheString(s, in);
        System.out.println(ans);

    }
    String toggleTheString(String input1, int input2)
    {
       StringBuilder sb = new StringBuilder();
       char str[] = input1.toCharArray();
       if (input2 == 0) {
           for (int i = 0; i < str.length; i+=2)
              {
                   if (str[i] >= 'A' && str[i] <= 'Z')
                       str[i] = (char) (str[i] + 'a' - 'A');
                   else if (str[i] >= 'a' && str[i] <= 'z')
                       str[i] = (char) (str[i] + 'A' - 'a');

                   sb.append(str[i]);

               }


       }

       else if(input2 == 1)
       {
           for (int i=1; i<str.length; i+=2)
         {
                   if (str[i] >= 'A' && str[i] <= 'Z')
                       str[i] = (char) (str[i] + 'a' - 'A');
                   else if (str[i] >= 'a' && str[i] <= 'z')
                       str[i] = (char) (str[i] + 'A' - 'a');

                   sb.append(str[i]);

               }
       }
       else
       {
           for (int i=0; i<str.length; i++)
           {
                   if (str[i] >= 'A' && str[i] <= 'Z')
                       str[i] = (char) (str[i] + 'a' - 'A');
                   else if (str[i] >= 'a' && str[i] <= 'z')
                       str[i] = (char) (str[i] + 'A' - 'a');
                   sb.append(str[i]);
           }
           return sb.reverse().toString();

       }

       return sb.toString();
    }
}