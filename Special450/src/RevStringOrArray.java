import java.util.Scanner;

/*
* link : https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
public class RevStringOrArray
{

    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            int start = 0;
            int end = s.length()-1;
            while(start< end)
            {
                char c = s.charAt(start);
                char d = s.charAt(end);
                s = s.substring(0, start)
                        + d
                        + s.substring(start + 1);
                s = s.substring(0, end)
                        + c
                        + s.substring(end + 1);



                start++;
                end --;
            }

            System.out.println(s);


        }
    }
}
