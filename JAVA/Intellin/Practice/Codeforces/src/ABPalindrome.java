import java.util.Scanner;

public class ABPalindrome
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count1 =0, count0 = 0;
            int  iniA =a, iniB = b;
            String s = sc.next();
            int len = s.length();
            for(int i =0;i<len;i++)
            {
                char c = s.charAt(i);
                if(c=='0')
                   a--;
                else if(c=='1')
                   b--;
            }

//            System.out.println(a +" :a  and b: "+b );
            if( (a<0 || b<0 ) || (len%2==0 && (iniA%2!=0 || iniB%2!=0 ))) {
//                System.out.println("HERE");
                System.out.println(-1);
            }else
            {
                char c[] = s.toCharArray();
                int i = 0, j =len   -1;
                boolean find = true;
                while(i<j && find)
                {
                    char c1 = c[i];
                    char c2 = c[j];
                    if(c1=='?' && c2=='?')
                    {
                        //both can be change
//                        if(a>1)
//                        {
//                            c[i]= '0';
//                            c[j]= '0';
//                            a= a-2;
//
//
//
//                        }
//                        else if(b>1)
//                        {
//                            c[i]= '1';
//                            c[j]= '1';
//                           b = b-2;
//
//                        }
//                        else
//                        {
//                            find = false;
//                            break;
//
//                        }

                    }
                    else if(c1=='?' && c2!='?')
                    {
                        if(c2=='1')
                        {
                            if(b>0)
                            {
                                c[i] = '1';
                                b--;

                            }
                            else
                            {
                                find = false;
                                break;
                            }

                        }
                        else
                        {
                            if(a>0)
                            {
                                c[i] = '0';
                                a--;
                            }
                            else
                            {
                                find = false;
                                break;
                            }

                        }
                    }
                    else if(c2=='?' && c1!='?')
                    {

                        if(c1=='1')
                        {
                            if(b>0)
                            {
                                c[j] = '1';
                                b--;

                            }
                            else
                            {
                                find = false;
                                break;

                            }
                        }
                        else
                        {
                            if(a>0)
                            {
                                c[j] = '0';
                                a--;
                            }
                            else
                            {
                                find = false;
                                break;
                            }

                        }

                    }
                    else if(c1!=c2){
                        find = false;
                        break;
                    }
                    i++;
                    j--;
                }

                i = 0;
                j =len-1;
                while(i<j)
                {
                    char c1 = c[i];
                    char c2 = c[j];
                    if(c1=='?' && c2=='?')
                    {
                        //both can be change
                        if(a>1)
                        {
                            c[i]= '0';
                            c[j]= '0';
                            a= a-2;



                        }
                        else if(b>1)
                        {
                            c[i]= '1';
                            c[j]= '1';
                           b = b-2;

                        }
                        else
                        {
                            find = false;
                            break;

                        }

                    }
                    i++;
                    j--;


                }
                if(len%2!=0)
                {
                    int mid = len/2;
                    if(c[mid]=='?')
                    {
                        if(a>0)
                        {
                            c[mid] = '0';
                            a--;


                        }
                        else
                        {
                            c[mid] = '1';
                            b--;
                        }
                    }


                }
                if(find)
                {
                    String ans = new String(c);
                    System.out.println(ans);

                }
                else
                    System.out.println("-1");
            }



        }
    }
}
