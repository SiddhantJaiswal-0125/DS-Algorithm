import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        int len = s.length();

        boolean check = true;
        for(int i = 0;i<len;i++)
        {

            char c = s.charAt(i);
            if(c!=')')
                st.push(c);
            else
            {

                check = true;
                while(st.isEmpty() == false && st.peek()!='(')
                {

                    st.pop();
                    check = false;


                }
                st.pop();

            }
            // if(check)

            // else 





        }
        System.out.println(check);




    }

}