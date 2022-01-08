import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            for(int i =0;i<n;i++)
            {
                int r = 0;
                    char c = s.charAt(i);
                    if(c>='0' && c<='9')
                    {

                        r = k %10;
                        if(c+r > '9')
                        {
                            int p = (c+r)-'9';
                            System.out.println(p%10);
                        }
                        else {
                            c = (char) (c + r);

                            System.out.print(c);
                        }


                    }
                    else if(c>='A' && c<='Z')
                    {
                        r = k %26;
                        if(c+r > 'Z')
                        {
                            int p = (c+r) - 'Z';

                            System.out.print((char) (  (  (p%26)-1) + 'A')  );

                        }
                        else {
                            c = (char) (c + r);

                            System.out.print(c);
                        }




                    }
                    else if(c>='a' && c<='z')
                    {
                        r = k %26;
                        if(c+r > 'z')
                        {

                            int p = (c+r) - 'z';
                            System.out.print((char)((p%26)-1 + 'a'));

                        }
                        else {
                            c = (char) (c + r);

                            System.out.print(c);
                        }
                    }
                    else
                        System.out.print(c);


            }


            System.out.println();


        }

    }
}
//16
//        50
//        Aarambh@1800-hrs