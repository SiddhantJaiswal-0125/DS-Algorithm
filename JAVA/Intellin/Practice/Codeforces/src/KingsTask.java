import java.util.Arrays;
import java.util.Scanner;

public class KingsTask
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[2*n];
        int acopy [] = new int[2*n];

        for(int i =0;i<2*n;i++) {
            a[i] = sc.nextInt();
            acopy[i] = a[i];
        }

        int count = 0;
        if(n%2==0)
        {
            boolean found = false;
            int count1 = 0;



            if(check(a))
            {
                //count =0
//                found = true;

                System.out.println(count);

            }
            else {
                shift1(a);
                count++;
                if (check(a)) {
                    //count =  1;
                    found = true;
//                    System.out.println(count);

                } else {
                    shift2(a);
                    count++;
                    if (check(a)) {
                        //count =  2;
//                        System.out.println(count);

                        found = true;
                    } else {
                        shift1(a);
                        count++;
                        if (check(a)) {
                            //count =  3;
                            found = true;
//                            System.out.println(count);

                        } else {
                            shift2(a);
                            count++;
                            if (check(a)) {
                                //count 4
                                found = true;
//                                System.out.println(count);

                            }
//                            else
//                                System.out.println(-1);
                        }
                    }
                }


                //COUNT 2


                if (check(acopy)) {
                    //count =0
                    found = true;
//                System.out.println(count);

                } else {
                    shift2(acopy);
                    count1++;
                    if (check(acopy)) {
                        //count =  1;
                        found = true;
//                    System.out.println(count);

                    } else {
                        shift1(acopy);
                        count1++;
                        if (check(acopy)) {
                            //count =  2;
                            found = true;
//                        System.out.println(count);

                        } else {
                            shift2(acopy);
                            count1++;
                            if (check(acopy)) {
                                //count =  3;
                                found = true;
//                            Syst/em.out.println(count);

                            } else {
                                shift1(acopy);
                                count1++;
                                if (check(acopy)) {
                                    //count 4
                                    found = true;
//                                System.out.println(count);

                                }
//                            else
//                                System.out.println(-1);
                            }
                        }
                    }
                }
                if (found)
                    System.out.println(Math.min(count, count1));
                else System.out.println(-1);

            }

        }
        else
        {
            boolean found = false;
            boolean first = true;
            boolean second = true;

            int count1 = 0;
            for(int i =0;i< (2*n) ;i++)
            {
                if (check(a)) {
                 found = true;
                    break;
                }else if(first)
                {
                    count++;
                    shift1(a);
                    first = false;
                }
                else
                {
                    count++;
                    shift2(a);
                    first = true;
                }


                if (check(acopy))
                {
                    found = true;
                    break;}
                else if(second)
                {
                    count1++;
                    shift2(acopy);
                    second = false;
                }
                else
                {
                    count1++;
                    shift1(acopy);
                    second = true;
                }

            }
            if (found)
            System.out.println(Math.min(count,count1));
            else
                System.out.println(-1);


        }

//        dis(a);



    }
    static void shift1(int ar[])
    {
        int n = ar.length;
//        System.out.println("N: "+n);
        for(int i = 0;i<n-1;)
        {
            //swap
            int temp = ar[i];
            ar[i] = ar[i+1];
            ar[i+1] = temp;

            i = i+2;


        }
    }
    static void shift2(int ar[])
    {
        int n = ar.length /2;
        for(int i = 0;i<n;i++)
        {
            //swap
            int temp = ar[i];
            ar[i] = ar[n+i];
            ar[n+i] = temp;


        }
    }


    static  boolean check (int ar[])
    {
        int n = ar.length;
        for (int i= 0;i<n;i++)
            if(ar[i] !=(i+1))
                return  false;
            return  true;
    }
    static  boolean checkSame(int ar [], int arcopy[])
    {
        int n = ar.length;
        for(int i =0;i<n;i++)
            if(ar[i]!=arcopy[i])
                return  false;


            return  true;

    }
    static  void dis(int a[])
    {
        for(int i : a)
            System.out.print(i+ " ");

        System.out.println();

    }


}
